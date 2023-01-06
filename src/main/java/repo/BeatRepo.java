package repo;

import model.Beat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeatRepo extends MongoRepository<Beat, String> {
}
