package naderdeghaili.u5w2d4hw.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record NewAuthorDTO(
        @NotBlank(message = "il nome è obbligatorio") @Size(min = 2, max = 20, message = "il nome deve essere compreso tra 2 e 20 caratteri") String nome,
        @NotBlank(message = "il cognome è obbligatorio") @Size(min = 2, max = 20, message = "il cognome deve essere compreso tra 2 e 20 caratteri") String cognome,
        @NotBlank(message = "la mail è obbligatoria") @Email(message = "la mail non è nel formato corretto") String email,
        @NotNull(message = "la data di nascita è obbligatoria") LocalDate dataDiNascita) {
    @Override
    public String toString() {
        return
                "nome: " + nome +
                        " | cognome: " + cognome +
                        " | email: " + email +
                        " | dataDiNascita: " + dataDiNascita
                ;
    }
}
