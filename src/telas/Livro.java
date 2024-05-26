package telas;

public class Livro {
	
    private String titulo;
    private String autor;
    private String sinopse;

    public Livro(String titulo, String autor, String sinopse) {
        this.titulo = titulo;
        this.autor = autor;
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopse() {
        return sinopse;
    }
}
