package player.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import player.entity.Player;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {

  Optional<Player> findByPlayerId(String playerId);

}