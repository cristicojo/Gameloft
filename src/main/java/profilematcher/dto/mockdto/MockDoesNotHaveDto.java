package profilematcher.dto.mockdto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class MockDoesNotHaveDto {

  private List<String> items;
}
