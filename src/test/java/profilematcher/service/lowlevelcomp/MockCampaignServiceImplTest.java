package profilematcher.service.lowlevelcomp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import profilematcher.util.builder.ProfileMatcherBuilder;

@ExtendWith(MockitoExtension.class)
public class MockCampaignServiceImplTest {

  @InjectMocks
  private MockCampaignServiceImpl mockCampaignService;

  @Test
  void shouldGetCurrentCampaign() {

    var currentCampaign = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();

    assertEquals(currentCampaign.getMatchers().getLevel().getMax(),
        mockCampaignService.getCurrentCampaign().getMatchers().getLevel().getMax());

    assertEquals(currentCampaign.getMatchers().getLevel().getMin(),
        mockCampaignService.getCurrentCampaign().getMatchers().getLevel().getMin());

    assertEquals(currentCampaign.getName(),
        mockCampaignService.getCurrentCampaign().getName());

    assertEquals(currentCampaign.getGame(),
        mockCampaignService.getCurrentCampaign().getGame());

    assertEquals(currentCampaign.getMatchers().getHas().getCountry().size(),
        mockCampaignService.getCurrentCampaign().getMatchers().getHas().getCountry().size());
  }
}
