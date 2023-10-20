package player.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import player.dto.PlayerDto;
import player.service.highlevelcomp.PlayerService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService service;


  @GetMapping(value = "/player/{id}")
  public ResponseEntity<PlayerDto> findById(@PathVariable(value = "id") String playerId) {
    return service.getById(playerId);
  }


  @PostMapping(value = "/player/create")
  public ResponseEntity<PlayerDto> save(@RequestBody PlayerDto playerDto) {
    return service.create(playerDto);
  }
}
