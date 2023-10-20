package player.service.highlevelcomp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import player.dto.PlayerDto;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final IPlayerService iPlayerService;

  public ResponseEntity<PlayerDto> getById(String playerId) {
    return iPlayerService.getById(playerId);
  }


  public ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto) {
    return iPlayerService.create(newPlayerDto);
  }
}
