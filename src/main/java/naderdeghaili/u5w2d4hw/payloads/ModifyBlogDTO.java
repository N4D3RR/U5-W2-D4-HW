package naderdeghaili.u5w2d4hw.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ModifyBlogDTO(
        @NotBlank(message = "la categoria è obbligatoria")
        @Size(min = 2, max = 20, message = "la categoria deve essere compresa tra 2 e 20 caratteri")
        String categoria,
        @NotBlank(message = "il titolo è obbligatorio")
        @Size(min = 2, max = 30, message = "il titolo deve essere compreso tra 2 e 30 caratteri")
        String titolo,
        @NotBlank(message = "il contenuto è obbligatorio")
        @Size(min = 2, max = 1000, message = "il contenuto deve essere compreso tra 2 e 1000 caratteri")
        String contenuto,
        @NotNull
        int tempoDiLettura) {
    @Override
    public String toString() {
        return
                "categoria: " + categoria +
                        " | titolo: " + titolo +
                        " | contenuto: " + contenuto +
                        " | tempoDiLettura: " + tempoDiLettura
                ;
    }
}
