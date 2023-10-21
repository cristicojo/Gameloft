package profilematcher.dto.mockdto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class MockHasDto {

  private List<String> country;

  private List<String> items;
}
