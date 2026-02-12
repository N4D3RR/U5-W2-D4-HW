package naderdeghaili.u5w2d4hw.controllers;

import naderdeghaili.u5w2d4hw.entities.Blog;
import naderdeghaili.u5w2d4hw.payloads.NewBlogPayload;
import naderdeghaili.u5w2d4hw.services.BlogsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    private final BlogsService blogsService;

    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    //GET ALL
    @GetMapping
    public List<Blog> findAll() {
        return this.blogsService.findAll();
    }

    //POST BLOG
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody NewBlogPayload payload) {
        return this.blogsService.saveBlog(payload);
    }


    //GET SINGLE BLOG
    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable UUID blogId) {
        return this.blogsService.findById(blogId);
    }

    //PUT BLOG
    @PutMapping("/{blogId}")
    public Blog getBlogByIdAndUpdate(@PathVariable UUID blogId, @RequestBody NewBlogPayload payload) {
        return this.blogsService.findByIdAndUpdate(blogId, payload);
    }

    //DELETE BLOG
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogByIdAndDelete(@PathVariable UUID blogId) {
        this.blogsService.findByIdAndDelete(blogId);
    }
}
