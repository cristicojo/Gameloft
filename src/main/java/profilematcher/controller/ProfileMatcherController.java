package profilematcher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import profilematcher.dto.PlayerDto;
import profilematcher.service.highlevelcomp.ProfileMatcherService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProfileMatcherController {

  private final ProfileMatcherService service;


  @GetMapping(value = "/get_client_config/{player_id}")
  public ResponseEntity<PlayerDto> findProfileMatcherByPlayerId(@PathVariable(value = "player_id") String playerId) {
    return new ResponseEntity<>(service.getProfileMatcher(playerId), HttpStatus.OK);
  }


  @PostMapping(value = "/player/create")
  public ResponseEntity<PlayerDto> save(@RequestBody PlayerDto playerDto) {
    return new ResponseEntity<>(service.create(playerDto), HttpStatus.CREATED);
  }
}
