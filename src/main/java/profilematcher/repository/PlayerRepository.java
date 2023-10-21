package profilematcher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import profilematcher.entity.Player;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {

  Optional<Player> findByPlayerId(String playerId);

}