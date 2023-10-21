package profilematcher.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "clan")
public class Clan {

  @Id
  @Field(name = "id")
  private String id;

  private String name;
}
