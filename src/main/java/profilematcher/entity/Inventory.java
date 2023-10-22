package profilematcher.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "inventory")
public class Inventory {

  private int cash;

  private int coins;

  @Field(name = "item_1")
  private int item1;

  @Field(name = "item_34")
  private int item34;

  @Field(name = "item_55")
  private int item55;

}
