package player.service.lowlevelcomp;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import player.dto.PlayerDto;
import player.entity.Player;
import player.repository.PlayerRepository;
import player.service.highlevelcomp.IPlayerService;

@Component
@RequiredArgsConstructor
public class PlayerServiceImpl implements IPlayerService {

  private final PlayerRepository repo;
  private final ModelMapper modelMapper;

  @Override
  public ResponseEntity<PlayerDto> getById(String playerId) {
    return new ResponseEntity<>(modelMapper.map(repo.findByPlayerId(playerId).orElseThrow(() ->
        new ResourceNotFoundException("Could not found a player with id: " + playerId)), PlayerDto.class),
        HttpStatus.OK);
  }


  @Override
  public ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto) {
    return new ResponseEntity<>(modelMapper.map(repo.save(modelMapper.map(newPlayerDto, Player.class)),
        PlayerDto.class), HttpStatus.CREATED);
  }
}
