package naderdeghaili.u5w2d4hw.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.entities.Blog;
import naderdeghaili.u5w2d4hw.exceptions.NotFoundException;
import naderdeghaili.u5w2d4hw.payloads.ModifyBlogDTO;
import naderdeghaili.u5w2d4hw.payloads.NewBlogDTO;
import naderdeghaili.u5w2d4hw.repositories.AuthorsRepository;
import naderdeghaili.u5w2d4hw.repositories.BlogsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BlogsService {

    private final BlogsRepository blogsRepository;
    private final AuthorsRepository authorsRepository;

    public BlogsService(BlogsRepository blogsRepository, AuthorsRepository authorsRepository) {
        this.blogsRepository = blogsRepository;
        this.authorsRepository = authorsRepository;
    }


    //GET lista blog
    public List<Blog> findAll() {
        return blogsRepository.findAll();
    }

    //POST blog
    public Blog saveBlog(NewBlogDTO payload) {
        Author authorDB = authorsRepository.findById(payload.authorId()).orElseThrow(() -> new NotFoundException(payload.authorId()));
        Blog newBlog = new Blog(payload.categoria(), payload.titolo(), payload.contenuto(), payload.tempoDiLettura(), authorDB);

        return blogsRepository.save(newBlog);
    }

    //GET singolo blog
    public Blog findById(UUID blogId) {

        return blogsRepository.findById(blogId).orElseThrow(() -> new NotFoundException(blogId));
    }

    //PUT blog
    public Blog findByIdAndUpdate(UUID blogId, ModifyBlogDTO payload) {
        Blog found = this.findById(blogId);

        found.setCategoria(payload.categoria());
        found.setTitolo(payload.titolo());
        found.setContenuto(payload.contenuto());
        found.setTempoDiLettura(payload.tempoDiLettura());

        Blog modifiedBlog = this.blogsRepository.save(found);

        return modifiedBlog;
    }

    //DELETE blog
    public void findByIdAndDelete(UUID blogId) {
        Blog found = this.findById(blogId);
        this.blogsRepository.delete(found);
    }

}