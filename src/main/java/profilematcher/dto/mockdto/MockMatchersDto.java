package profilematcher.dto.mockdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MockMatchersDto {

  private MockLevelDto level;

  private MockHasDto has;

  private MockDoesNotHaveDto doesNotHave;

  private String startDate;

  private String endDate;

  private boolean enabled;

  private String lastUpdated;
}
