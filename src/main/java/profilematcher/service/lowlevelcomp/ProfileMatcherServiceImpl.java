package profilematcher.service.lowlevelcomp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import profilematcher.dto.InventoryDto;
import profilematcher.dto.PlayerDto;
import profilematcher.entity.Player;
import profilematcher.repository.PlayerRepository;
import profilematcher.service.highlevelcomp.IProfileMatcherService;
import profilematcher.service.highlevelcomp.MockCampaignService;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfileMatcherServiceImpl implements IProfileMatcherService {

  private final PlayerRepository repo;
  private final ModelMapper modelMapper;
  private final MockCampaignService mockCampaignService;


  @Override
  public PlayerDto getProfileMatcher(String playerId) {

    log.info("Fetching player with id " + playerId);
    var player = repo.findByPlayerId(playerId).orElseThrow(() -> {
      log.error("Player with id " + playerId + " was not found");
      return new ResourceNotFoundException("Could not found a player with id: " + playerId);
    });
    log.info("Player fetched " + player);

    return matchAndUpdatePlayer(player);

  }

  private PlayerDto matchAndUpdatePlayer(Player player) {

    var playerProfileDto = modelMapper.map(player, PlayerDto.class);

    var currentCampaign = mockCampaignService.getCurrentCampaign();
    log.info("Cuurent campaign fetched is " + currentCampaign);

    Set<String> hasItems = new HashSet<>(currentCampaign.getMatchers()
        .getHas()
        .getItems());
    Set<String> doesNotHaveItems = new HashSet<>(currentCampaign.getMatchers()
        .getDoesNotHave()
        .getItems());

    if ((playerProfileDto.getLevel() >= currentCampaign.getMatchers().getLevel().getMin())
        && (playerProfileDto.getLevel() <= currentCampaign.getMatchers().getLevel().getMax())
        || (currentCampaign.getMatchers().getHas().getCountry().contains(playerProfileDto.getCountry()))
        || (doesInventoryDtoContainsField(hasItems))
        || (!doesInventoryDtoContainsField(doesNotHaveItems))) {

      playerProfileDto.getActiveCampaigns().add(currentCampaign.getName());
      log.info("Match complete and the player profile has been updated " + playerProfileDto);
      return playerProfileDto;
    }

    log.info("Match incomplete and the player profile has not been updated " + playerProfileDto);
    return playerProfileDto;

  }

  private boolean doesInventoryDtoContainsField(Set<String> hasItems) {

    Set<String> fieldSet = Arrays.stream(InventoryDto.class.getDeclaredFields())
        .map(Field::getName)
        .collect(Collectors.toSet());

    return fieldSet.containsAll(hasItems);
  }


  @Override
  public PlayerDto create(PlayerDto newPlayerDto) {
    log.info("Create player " + newPlayerDto);
    return modelMapper.map(repo.save(modelMapper.map(newPlayerDto, Player.class)),
        PlayerDto.class);
  }
}
