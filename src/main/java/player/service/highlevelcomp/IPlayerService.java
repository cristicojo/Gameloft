package player.service.highlevelcomp;

import org.springframework.http.ResponseEntity;
import player.dto.PlayerDto;

public interface IPlayerService {

  ResponseEntity<PlayerDto> getById(String playerId);

  ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto);
}
