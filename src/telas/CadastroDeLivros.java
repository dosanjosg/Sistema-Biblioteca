package telas;

import java.util.ArrayList;
import java.util.List;

public class CadastroDeLivros {
	
	public static List<Livro> livros;
	
	public CadastroDeLivros() {
		
		livros = new ArrayList<>();
	}
	
	public void adicionaLivro(Livro livro) {
		
		livros.add(livro);
	}
	
	public List<Livro> getLivros(){
		return livros;
	}
}
