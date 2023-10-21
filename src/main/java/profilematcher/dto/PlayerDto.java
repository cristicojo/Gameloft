package profilematcher.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlayerDto {

  private String playerId;

  private String credential;

  private String created;

  private String modified;

  private String lastSession;

  private int totalSpent;

  private int totalRefund;

  private int totalTransactions;

  private String lastPurchase;

  private List<String> activeCampaigns;

  private List<DeviceDto> devices;

  private int level;

  private int xp;

  private int totalPlaytime;

  private String country;

  private String language;

  private String birthdate;

  private String gender;

  private InventoryDto inventory;

  private ClanDto clan;

  private String customField;
}
