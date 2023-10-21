package profilematcher.service.highlevelcomp;

import org.springframework.http.ResponseEntity;
import profilematcher.dto.mockdto.MockCurrentCampaignDto;

public interface ICampaignService {

  ResponseEntity<MockCurrentCampaignDto> getCurrentCampaign();

}
