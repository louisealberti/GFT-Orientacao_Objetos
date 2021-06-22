package one.digitalinnovation.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {

	private String nome;
	private List<Conteudo> conteudosInscritos = new ArrayList<Conteudo>();
	private List<Conteudo> conteudosConcluidos = new ArrayList<Conteudo>();

	public void inscrever(Conteudo conteudo) {
		if (conteudosInscritos.contains(conteudo)) {
			System.out.println("Você já se inscreveu nesse conteúdo!");
		} else {
			conteudosInscritos.add(conteudo);
		}
	}

	public void inscrever(Bootcamp bootcamp) {
		for (Conteudo conteudo : bootcamp.getConteudos()) {
			inscrever(conteudo);
		}
		// Alternativa API de Stream
//		bootcamp.getConteudos().stream().forEach(this::inscrever);
		bootcamp.getDevs().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
		if (conteudo.isPresent()) {
			conteudosConcluidos.add(conteudo.get());
			conteudosInscritos.remove(conteudo.get());
		} else {
			System.err.println("Você não está mais incrito em nenhum contúdo.");
		}
	}

	public double calcularTotalXp() {
		return conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
