package naderdeghaili.u5w2d4hw.repositories;

import naderdeghaili.u5w2d4hw.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorsRepository extends JpaRepository<Author, UUID> {

}
