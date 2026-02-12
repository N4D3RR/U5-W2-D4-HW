package naderdeghaili.u5w2d4hw.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Autore non trovato");
    }
}
