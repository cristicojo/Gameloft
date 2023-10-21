package profilematcher.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "device")
public class Device {

  @Id
  private int id;

  private String model;

  private String carrier;

  private String firmware;

}
