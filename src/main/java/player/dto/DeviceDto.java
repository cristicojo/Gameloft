package player.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDto {

  private int id;

  private String model;

  private String carrier;

  private String firmware;
}
