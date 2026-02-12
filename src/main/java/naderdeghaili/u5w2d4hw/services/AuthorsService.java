package naderdeghaili.u5w2d4hw.services;

import com.cloudinary.Cloudinary;
import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w2d4hw.entities.Author;
import naderdeghaili.u5w2d4hw.exceptions.NotFoundException;
import naderdeghaili.u5w2d4hw.payloads.NewAuthorDTO;
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
    private final Cloudinary clUploader;

    public AuthorsService(AuthorsRepository authorsRepository, Cloudinary clUploader) {
        this.authorsRepository = authorsRepository;
        this.clUploader = clUploader;
    }


    //GET lista autori
    public Page<Author> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.authorsRepository.findAll(pageable);
    }

    //POST autore
    public Author saveAuthor(NewAuthorDTO payload) {
        Author newAuthor = new Author(payload.nome(), payload.cognome(), payload.email(), payload.dataDiNascita());

        return authorsRepository.save(newAuthor);
    }

    //GET singolo autore
    public Author findById(UUID authorId) {
        return authorsRepository.findById(authorId).orElseThrow(() -> new NotFoundException(authorId));
    }

    //PUT AUTHOR
    public Author findByIdAndUpdate(UUID authorId, NewAuthorDTO payload) {
        Author found = this.findById(authorId);

        found.setNome(payload.nome());
        found.setCognome(payload.cognome());
        found.setEmail(payload.email());
        found.setDataDiNascita(payload.dataDiNascita());

        Author modifiedAuthor = this.authorsRepository.save(found);

        log.info("l'autore con id " + authorId + " è stato modificato");

        return modifiedAuthor;

    }

    //DELETE AUTHOR

    public void findByIdAndDelete(UUID authorId) {
        Author found = this.findById(authorId);
        this.authorsRepository.delete(found);
    }

    //PATCH PROFILE PIC
    public

}
