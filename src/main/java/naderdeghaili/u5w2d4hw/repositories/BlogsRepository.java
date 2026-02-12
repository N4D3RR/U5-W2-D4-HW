package naderdeghaili.u5w2d4hw.repositories;

import naderdeghaili.u5w2d4hw.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogsRepository extends JpaRepository<Blog, UUID> {

}
