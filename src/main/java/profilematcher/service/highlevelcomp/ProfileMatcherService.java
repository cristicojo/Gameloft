package profilematcher.service.highlevelcomp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import profilematcher.dto.PlayerDto;

@Service
@RequiredArgsConstructor
public class ProfileMatcherService {

  private final IProfileMatcherService iProfileMatcherService;

  public ResponseEntity<PlayerDto> getProfileMatcher(String playerId) {
    return iProfileMatcherService.getProfileMatcher(playerId);
  }


  public ResponseEntity<PlayerDto> create(PlayerDto newPlayerDto) {
    return iProfileMatcherService.create(newPlayerDto);
  }
}
