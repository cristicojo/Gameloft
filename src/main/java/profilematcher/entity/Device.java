package profilematcher.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "device")
public class Device {

  @Id
  private int id;

  private String model;

  private String carrier;

  private String firmware;

}
