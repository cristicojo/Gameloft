package profilematcher.dto.mockdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MockLevelDto {

  private int min;

  private int max;
}
