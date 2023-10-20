package player.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "player")
public class Player {

  @Id
  @Field(name = "player_id")
  private String playerId;

  private String credential;

  private String created;

  private String modified;

  @Field(name = "last_session")
  private String lastSession;

  @Field(name = "total_spent")
  private int totalSpent;

  @Field(name = "total_refund")
  private int totalRefund;

  @Field(name = "total_transactions")
  private int totalTransactions;

  @Field(name = "last_purchase")
  private String lastPurchase;

  @Field(name = "active_campaigns")
  private List<String> activeCampaigns;

  private List<Device> devices;

  private int level;

  private int xp;

  @Field(name = "total_playtime")
  private int totalPlaytime;

  private String country;

  private String language;

  private String birthdate;

  private String gender;

  private Inventory inventory;

  private Clan clan;

  @Field(name = "_customField")
  private String customField;
}