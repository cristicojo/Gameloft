package profilematcher.service.lowlevelcomp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import profilematcher.dto.PlayerDto;
import profilematcher.entity.Player;
import profilematcher.repository.PlayerRepository;
import profilematcher.service.highlevelcomp.ICampaignService;
import profilematcher.service.highlevelcomp.MockCampaignService;
import profilematcher.util.builder.ProfileMatcherBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProfileMatcherServiceImplTest {

  @Mock
  private PlayerRepository repo;

  @Mock
  private ModelMapper modelMapper;

  @Mock
  private MockCampaignService mockCampaignService;

  @Mock
  private ICampaignService iCampaignService;

  @InjectMocks
  private ProfileMatcherServiceImpl profileMatcherService;


  @Test
  void shouldGetProfileMatcherByLevelMinTest() {

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMin(3);

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(1);
    assertThat(profileMatcher.getBody().getActiveCampaigns().get(0)).isEqualTo(
        mockCurrentCampaignDto.getBody().getName());

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldGetProfileMatcherByLevelMaxTest() {

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(1);
    assertThat(profileMatcher.getBody().getActiveCampaigns().get(0)).isEqualTo(
        mockCurrentCampaignDto.getBody().getName());

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldGetProfileMatcherByCountryTest() {

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMax(0);
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMin(0);

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(1);
    assertThat(profileMatcher.getBody().getActiveCampaigns().get(0)).isEqualTo(
        mockCurrentCampaignDto.getBody().getName());

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldGetProfileMatcherByItem1Test() {

    List<String> countries = new ArrayList<>();
    countries.add("GB");

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMax(0);
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMin(0);
    mockCurrentCampaignDto.getBody().getMatchers().getHas().setCountry(countries);

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(1);
    assertThat(profileMatcher.getBody().getActiveCampaigns().get(0)).isEqualTo(
        mockCurrentCampaignDto.getBody().getName());

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldGetProfileMatcherByItem4Test() {

    List<String> items = new ArrayList<>();
    items.add("item11");
    List<String> countries = new ArrayList<>();
    countries.add("GB");

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMax(0);
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMin(0);
    mockCurrentCampaignDto.getBody().getMatchers().getHas().setCountry(countries);
    mockCurrentCampaignDto.getBody().getMatchers().getHas().setItems(items);

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(1);
    assertThat(profileMatcher.getBody().getActiveCampaigns().get(0)).isEqualTo(
        mockCurrentCampaignDto.getBody().getName());

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldNotMatchTest() {

    List<String> items11 = new ArrayList<>();
    items11.add("item11");
    List<String> countries = new ArrayList<>();
    countries.add("GB");
    List<String> items34 = new ArrayList<>();
    items34.add("item34");

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();
    var mockCurrentCampaignDto = ProfileMatcherBuilder.createMockCurrentCampaignDtoBuilder();
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMax(0);
    mockCurrentCampaignDto.getBody().getMatchers().getLevel().setMin(0);
    mockCurrentCampaignDto.getBody().getMatchers().getHas().setCountry(countries);
    mockCurrentCampaignDto.getBody().getMatchers().getHas().setItems(items11);
    mockCurrentCampaignDto.getBody().getMatchers().getDoesNotHave().setItems(items34);

    when(repo.findByPlayerId(player.getPlayerId())).thenReturn(Optional.of(player));
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);
    when(mockCampaignService.getCurrentCampaign()).thenReturn(mockCurrentCampaignDto);

    var profileMatcher = profileMatcherService.getProfileMatcher(player.getPlayerId());

    assertThat(profileMatcher.getBody().getActiveCampaigns().size()).isEqualTo(0);

    verify(repo, times(1)).findByPlayerId(player.getPlayerId());
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(mockCampaignService, times(1)).getCurrentCampaign();

  }

  @Test
  void shouldThrowExceptionWhenGetProfileMatcherTest() {

    when(repo.findByPlayerId(anyString())).thenReturn(Optional.empty());
    assertThrows(ResourceNotFoundException.class, () ->
        profileMatcherService.getProfileMatcher(anyString()));
  }

  @Test
  void createTest() {

    var player = ProfileMatcherBuilder.createPlayerBuilder();
    var playerDto = ProfileMatcherBuilder.createPlayerDtoBuilder();

    when(modelMapper.map(playerDto, Player.class)).thenReturn(player);
    when(repo.save(player)).thenReturn(player);
    when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);

    var savedPlayerDto = profileMatcherService.create(playerDto);
    assertThat(savedPlayerDto).isNotNull();

    verify(repo, times(1)).save(player);
    verify(modelMapper, times(1)).map(player, PlayerDto.class);
    verify(modelMapper, times(1)).map(playerDto, Player.class);

  }
}
