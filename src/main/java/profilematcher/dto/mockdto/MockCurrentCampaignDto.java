package profilematcher.dto.mockdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MockCurrentCampaignDto {

  private String game;

  private String name;

  private float priority;

  private MockMatchersDto matchers;

}
