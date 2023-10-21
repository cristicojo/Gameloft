package profilematcher.dto;

import lombok.Data;

@Data
public class DeviceDto {

  private int id;

  private String model;

  private String carrier;

  private String firmware;
}
