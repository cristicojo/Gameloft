package profilematcher.service.highlevelcomp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import profilematcher.dto.mockdto.MockCurrentCampaignDto;

@Service
@RequiredArgsConstructor
public class MockCampaignService {

  private final ICampaignService iCampaignService;

  public ResponseEntity<MockCurrentCampaignDto> getCurrentCampaign() {
    return iCampaignService.getCurrentCampaign();
  }
}
