package profilematcher.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "clan")
public class Clan {

  @Id
  @Field(name = "id")
  private String id;

  private String name;
}
