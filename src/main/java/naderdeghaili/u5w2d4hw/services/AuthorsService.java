package naderdeghaili.u5w2d4hw.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.exceptions.NotFoundException;
import naderdeghaili.u5w2d4hw.payloads.NewAuthorPayload;
import naderdeghaili.u5w2d4hw.repositories.AuthorsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AuthorsService {


    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    //GET lista autori
    public Page<Author> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.authorsRepository.findAll(pageable);
    }

    //POST autore
    public Author saveAuthor(NewAuthorPayload payload) {
        Author newAuthor = new Author(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDataDiNascita());

        return authorsRepository.save(newAuthor);
    }

    //GET singolo autore
    public Author findById(UUID authorId) {
        return authorsRepository.findById(authorId).orElseThrow(() -> new NotFoundException(authorId));
    }

    //PUT AUTHOR
    public Author findByIdAndUpdate(UUID authorId, NewAuthorPayload payload) {
        Author found = this.findById(authorId);

        found.setNome(payload.getNome());
        found.setCognome(payload.getCognome());
        found.setEmail(payload.getEmail());
        found.setDataDiNascita(payload.getDataDiNascita());

        Author modifiedAuthor = this.authorsRepository.save(found);

        log.info("l'autore con id " + authorId + " è stato modificato");

        return modifiedAuthor;

    }

    //DELETE AUTHOR

    public void findByIdAndDelete(UUID authorId) {
        Author found = this.findById(authorId);
        this.authorsRepository.delete(found);
    }
}
