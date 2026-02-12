package naderdeghaili.u5w2d4hw.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.entities.Blog;
import naderdeghaili.u5w2d4hw.exceptions.NotFoundException;
import naderdeghaili.u5w2d4hw.payloads.NewBlogPayload;
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
    public Blog saveBlog(NewBlogPayload payload) {
        Author authorDB = authorsRepository.findById(payload.getAuthorId()).orElseThrow(() -> new NotFoundException(payload.getAuthorId()));
        Blog newBlog = new Blog(payload.getCategoria(), payload.getTitolo(), payload.getContenuto(), payload.getTempoDiLettura(), authorDB);

        return blogsRepository.save(newBlog);
    }

    //GET singolo blog
    public Blog findById(UUID blogId) {

        return blogsRepository.findById(blogId).orElseThrow(() -> new NotFoundException(blogId));
    }

    //PUT blog
    public Blog findByIdAndUpdate(UUID blogId, NewBlogPayload payload) {
        Blog found = this.findById(blogId);

        found.setCategoria(payload.getCategoria());
        found.setTitolo(payload.getTitolo());
        found.setContenuto(payload.getContenuto());
        found.setTempoDiLettura(payload.getTempoDiLettura());

        Blog modifiedBlog = this.blogsRepository.save(found);

        return modifiedBlog;
    }

    //DELETE blog
    public void findByIdAndDelete(UUID blogId) {
        Blog found = this.findById(blogId);
        this.blogsRepository.delete(found);
    }

}