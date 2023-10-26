package profilematcher.service.lowlevelcomp;

import org.springframework.stereotype.Component;
import profilematcher.dto.mockdto.MockCurrentCampaignDto;
import profilematcher.dto.mockdto.MockDoesNotHaveDto;
import profilematcher.dto.mockdto.MockHasDto;
import profilematcher.dto.mockdto.MockLevelDto;
import profilematcher.dto.mockdto.MockMatchersDto;
import profilematcher.service.highlevelcomp.ICampaignService;

import java.util.List;

@Component
public class MockCampaignServiceImpl implements ICampaignService {


  @Override
  public MockCurrentCampaignDto getCurrentCampaign() {

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
                .country(List.of("US", "RO", "CA"))
                .items(List.of("item1"))
                .build())
            .doesNotHave(MockDoesNotHaveDto.builder()
                .items(List.of("item4"))
                .build())
            .startDate("2022-01-25 00:00:00Z")
            .endDate("2022-02-25 00:00:00Z")
            .enabled(true)
            .lastUpdated("2021-07-13 11:46:58Z")
            .build())
        .build();
  }
}
