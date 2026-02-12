package naderdeghaili.u5w2d4hw.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Blog() {
    }

    public Blog(String categoria, String titolo, String contenuto, int tempoDiLettura, Author author) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.createdAt = LocalDate.now();
        Random random = new Random();
        this.cover = "https://placecats.com/200/200";
        this.author = author;
    }


    public UUID getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                        " | categoria: " + categoria +
                        " | titolo: " + titolo +
                        " | cover: " + cover +
                        " | contenuto: " + contenuto +
                        " | tempoDiLettura: " + tempoDiLettura +
                        " | createdAt: " + createdAt +
                        " | autore: " + author.getNome() + " " + author.getCognome()
                ;
    }
}
