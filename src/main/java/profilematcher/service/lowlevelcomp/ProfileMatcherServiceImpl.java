package profilematcher.service.lowlevelcomp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import profilematcher.dto.InventoryDto;
import profilematcher.dto.PlayerDto;
import profilematcher.entity.Player;
import profilematcher.repository.PlayerRepository;
import profilematcher.service.highlevelcomp.IProfileMatcherService;
import profilematcher.service.highlevelcomp.MockCampaignService;

import java.util.Arrays;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProfileMatcherServiceImpl implements IProfileMatcherService {

  private final PlayerRepository repo;
  private final ModelMapper modelMapper;
  private final MockCampaignService mockCampaignService;


  @Override
  public ResponseEntity<PlayerDto> getProfileMatcher(String playerId) {

    log.info("Fetching player with id " + playerId);
    var player = repo.findByPlayerId(playerId).orElseThrow(() -> {
      log.error("Player with id " + playerId + " was not found");
      return new ResourceNotFoundException("Could not found a player with id: " + playerId);
    });
    log.info("Player fetched " + player);

    var updatedPlayerDto = matchAndUpdatePlayer(player);
    return new ResponseEntity<>(updatedPlayerDto, HttpStatus.OK);

  }

  private PlayerDto matchAndUpdatePlayer(Player player) {

    var playerProfileDto = modelMapper.map(player, PlayerDto.class);

    var currentCampaign = mockCampaignService.getCurrentCampaign();
    log.info("Cuurent campaign fetched is " + currentCampaign.getBody() + " with status code "
        + currentCampaign.getStatusCode());

    String item1 = currentCampaign.getBody().getMatchers().getHas().getItems().get(0);
    String item4 = currentCampaign.getBody().getMatchers().getDoesNotHave().getItems().get(0);

    if ((playerProfileDto.getLevel() == currentCampaign.getBody().getMatchers().getLevel().getMin())
        || (playerProfileDto.getLevel() == currentCampaign.getBody().getMatchers().getLevel().getMax())
        || (currentCampaign.getBody().getMatchers().getHas().getCountry().contains(playerProfileDto.getCountry()))
        || (doesInventoryDtoContainsField(item1))
        || (!doesInventoryDtoContainsField(item4))) {

      playerProfileDto.getActiveCampaigns().add(currentCampaign.getBody().getName());
      log.info("Match complete and the player profile has been updated " + playerProfileDto);
      return playerProfileDto;
    }

    log.info("Match incomplete and the player profile has not been updated " + playerProfileDto);
    return playerProfileDto;

  }

  private boolean doesInventoryDtoContainsField(String fieldName) {
    return Arrays.stream(InventoryDto.class.getDeclaredFields())
        .anyMatch(field -> field.getName().equals(fieldName));
  }


  @Override
  public ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto) {
    log.info("Create player " + newPlayerDto);
    return new ResponseEntity<>(
        modelMapper.map(repo.save(modelMapper.map(newPlayerDto, Player.class)),
            PlayerDto.class), HttpStatus.CREATED);
  }
}
