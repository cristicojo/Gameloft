package profilematcher.util.builder;

import lombok.experimental.UtilityClass;
import profilematcher.dto.ClanDto;
import profilematcher.dto.DeviceDto;
import profilematcher.dto.InventoryDto;
import profilematcher.dto.PlayerDto;
import profilematcher.dto.mockdto.MockCurrentCampaignDto;
import profilematcher.dto.mockdto.MockDoesNotHaveDto;
import profilematcher.dto.mockdto.MockHasDto;
import profilematcher.dto.mockdto.MockLevelDto;
import profilematcher.dto.mockdto.MockMatchersDto;
import profilematcher.entity.Clan;
import profilematcher.entity.Device;
import profilematcher.entity.Inventory;
import profilematcher.entity.Player;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProfileMatcherBuilder {



  public Player createPlayerBuilder() {
    return Player.builder()
        .playerId("97983be2-98b7-11e7-90cf-082e5f28d836")
        .credential("apple_credential")
        .created("2021-01-10 13:37:17Z")
        .modified("2021-01-23 13:37:17Z")
        .lastSession("2021-01-23 13:37:17Z")
        .totalSpent(400)
        .totalRefund(0)
        .totalTransactions(5)
        .lastPurchase("2021-01-22 13:37:17Z")
        .activeCampaigns(new ArrayList<>())
        .devices(List.of(Device.builder()
            .id(1)
            .model("apple iphone 11")
            .carrier("vodafone")
            .firmware("123")
            .build()))
        .level(3)
        .xp(1000)
        .totalPlaytime(144)
        .country("CA")
        .language("fr")
        .birthdate("2000-01-10 13:37:17Z")
        .gender("male")
        .inventory(Inventory.builder()
            .cash(123)
            .coins(123)
            .item1(1)
            .item34(3)
            .item55(2)
            .build())
        .clan(Clan.builder()
            .id("123456")
            .name("Hello world clan")
            .build())
        .customField("mycustom")
        .build();
  }

  public PlayerDto createPlayerDtoBuilder() {
    return PlayerDto.builder()
        .playerId("97983be2-98b7-11e7-90cf-082e5f28d836")
        .credential("apple_credential")
        .created("2021-01-10 13:37:17Z")
        .modified("2021-01-23 13:37:17Z")
        .lastSession("2021-01-23 13:37:17Z")
        .totalSpent(400)
        .totalRefund(0)
        .totalTransactions(5)
        .lastPurchase("2021-01-22 13:37:17Z")
        .activeCampaigns(new ArrayList<>())
        .devices(List.of(DeviceDto.builder()
            .id(1)
            .model("apple iphone 11")
            .carrier("vodafone")
            .firmware("123")
            .build()))
        .level(3)
        .xp(1000)
        .totalPlaytime(144)
        .country("CA")
        .language("fr")
        .birthdate("2000-01-10 13:37:17Z")
        .gender("male")
        .inventory(InventoryDto.builder()
            .cash(123)
            .coins(123)
            .item1(1)
            .item34(3)
            .item55(2)
            .build())
        .clan(ClanDto.builder()
            .id("123456")
            .name("Hello world clan")
            .build())
        .customField("mycustom")
        .build();
  }

  public MockCurrentCampaignDto createMockCurrentCampaignDtoBuilder() {

    List<String> countries = new ArrayList<>();
    countries.add("US");
    countries.add("RO");
    countries.add("CA");
    List<String> items1 = new ArrayList<>();
    items1.add("item1");
    List<String> items4 = new ArrayList<>();
    items4.add("item4");

    return MockCurrentCampaignDto.builder()
        .game("mygame")
        .name("mycampaign")
        .priority(10.5f)
        .matchers(MockMatchersDto.builder()
            .level(MockLevelDto.builder()
                .min(1)
                .max(3)
                .build())
            .has(MockHasDto.builder()
                .country(countries)
                .items(items1)
                .build())
            .doesNotHave(MockDoesNotHaveDto.builder()
                .items(items4)
                .build())
            .startDate("2022-01-25 00:00:00Z")
            .endDate("2022-02-25 00:00:00Z")
            .enabled(true)
            .lastUpdated("2021-07-13 11:46:58Z")
            .build())
        .build();
  }
}
