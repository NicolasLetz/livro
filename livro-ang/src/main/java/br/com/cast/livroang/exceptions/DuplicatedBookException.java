package br.com.cast.livroang.exceptions;

@SuppressWarnings("serial")
public class DuplicatedBookException extends Exception {
	public DuplicatedBookException() {
		super("Livro já está na lista");
	}
}
