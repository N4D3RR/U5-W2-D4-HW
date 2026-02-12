package naderdeghaili.u5w2d4hw.payloads;

import java.time.LocalDate;

public class NewAuthorPayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;

    public NewAuthorPayload(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

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
