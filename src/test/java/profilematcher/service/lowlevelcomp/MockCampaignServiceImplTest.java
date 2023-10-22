package profilematcher.service.lowlevelcomp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import profilematcher.dto.mockdto.MockCurrentCampaignDto;
import profilematcher.dto.mockdto.MockDoesNotHaveDto;
import profilematcher.dto.mockdto.MockHasDto;
import profilematcher.dto.mockdto.MockLevelDto;
import profilematcher.dto.mockdto.MockMatchersDto;
import profilematcher.util.builder.ProfileMatcherBuilder;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockCampaignServiceImplTest {

  @InjectMocks
  private MockCampaignServiceImpl mockCampaignService;

  @Test
  void shouldGetCurrentCampaign() {

    var currentCampaign = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();

    assertEquals(currentCampaign.getBody().getMatchers().getLevel().getMax(),
        mockCampaignService.getCurrentCampaign().getBody().getMatchers().getLevel().getMax());

    assertEquals(currentCampaign.getBody().getMatchers().getLevel().getMin(),
        mockCampaignService.getCurrentCampaign().getBody().getMatchers().getLevel().getMin());

    assertEquals(currentCampaign.getBody().getName(),
        mockCampaignService.getCurrentCampaign().getBody().getName());

    assertEquals(currentCampaign.getBody().getGame(),
        mockCampaignService.getCurrentCampaign().getBody().getGame());

    assertEquals(currentCampaign.getBody().getMatchers().getHas().getCountry().size(),
        mockCampaignService.getCurrentCampaign().getBody().getMatchers().getHas().getCountry().size());

    assertEquals(currentCampaign.getStatusCode(),
        mockCampaignService.getCurrentCampaign().getStatusCode());
  }
}
