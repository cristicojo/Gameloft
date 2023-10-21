package profilematcher.service.highlevelcomp;

import org.springframework.http.ResponseEntity;
import profilematcher.dto.PlayerDto;

public interface IProfileMatcherService {

  ResponseEntity<PlayerDto> getProfileMatcher(String playerId);

  ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto);
}
