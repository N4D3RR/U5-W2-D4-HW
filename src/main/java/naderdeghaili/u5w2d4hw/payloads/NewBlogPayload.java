package naderdeghaili.u5w2d4hw.payloads;

import java.util.UUID;

public class NewBlogPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private UUID authorId;

    public NewBlogPayload(String categoria, String titolo, String contenuto, int tempoDiLettura, UUID authorId) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.authorId = authorId;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    @Override
    public String toString() {
        return
                "categoria: " + categoria +
                        " | titolo: " + titolo +
                        " | contenuto: " + contenuto +
                        " | tempoDiLettura: " + tempoDiLettura + " | autore: " + authorId
                ;
    }
}
