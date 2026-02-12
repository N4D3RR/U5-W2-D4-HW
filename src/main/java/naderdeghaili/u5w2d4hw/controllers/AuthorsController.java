package naderdeghaili.u5w2d4hw.controllers;

import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.payloads.NewAuthorPayload;
import naderdeghaili.u5w2d4hw.services.AuthorsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    //GET ALL
    @GetMapping
    public Page<Author> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "15") int size) {
        return this.authorsService.findAll(page, size);
    }

    //POST AUTHOR
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody NewAuthorPayload payload) {
        return this.authorsService.saveAuthor(payload);
    }


    //GET SINGLE AUTHOR
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable UUID authorId) {
        return this.authorsService.findById(authorId);
    }

    //PUT AUTHOR
    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable UUID authorId, @RequestBody NewAuthorPayload payload) {
        return this.authorsService.findByIdAndUpdate(authorId, payload);
    }

    //DELETE AUTHOR
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAuthorByIdAndDelete(@PathVariable UUID authorId) {
        this.authorsService.findByIdAndDelete(authorId);
    }

}
