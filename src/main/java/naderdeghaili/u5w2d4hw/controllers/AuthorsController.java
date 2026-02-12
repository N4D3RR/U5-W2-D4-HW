package naderdeghaili.u5w2d4hw.controllers;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.exceptions.ValidationException;
import naderdeghaili.u5w2d4hw.payloads.NewAuthorDTO;
import naderdeghaili.u5w2d4hw.services.AuthorsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Page<Author> findAll(@RequestParam(defaultValue = "0") @Min(0) @Max(50) int page,
                                @RequestParam(defaultValue = "15") @Min(0) @Max(15) int size) {
        return this.authorsService.findAll(page, size);
    }

    //POST AUTHOR
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody @Validated NewAuthorDTO payload, BindingResult validateResult) {
        if (validateResult.hasErrors()) {
            List<String> errorList = validateResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException((errorList));
        } else {
            return this.authorsService.saveAuthor(payload);
        }
    }


    //GET SINGLE AUTHOR
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable UUID authorId) {
        return this.authorsService.findById(authorId);
    }

    //PUT AUTHOR
    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable UUID authorId, @RequestBody NewAuthorDTO payload) {
        return this.authorsService.findByIdAndUpdate(authorId, payload);
    }

    //DELETE AUTHOR
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAuthorByIdAndDelete(@PathVariable UUID authorId) {
        this.authorsService.findByIdAndDelete(authorId);
    }

}
