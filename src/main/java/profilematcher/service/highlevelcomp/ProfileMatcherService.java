package profilematcher.service.highlevelcomp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import profilematcher.dto.PlayerDto;

@Service
@RequiredArgsConstructor
public class ProfileMatcherService {

  private final IProfileMatcherService iProfileMatcherService;

  public PlayerDto getProfileMatcher(String playerId) {
    return iProfileMatcherService.getProfileMatcher(playerId);
  }


  public PlayerDto create(PlayerDto newPlayerDto) {
    return iProfileMatcherService.create(newPlayerDto);
  }
}
