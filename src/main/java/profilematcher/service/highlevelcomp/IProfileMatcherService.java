package profilematcher.service.highlevelcomp;

import profilematcher.dto.PlayerDto;

public interface IProfileMatcherService {

  PlayerDto getProfileMatcher(String playerId);

  PlayerDto create(PlayerDto newPlayerDto);
}
