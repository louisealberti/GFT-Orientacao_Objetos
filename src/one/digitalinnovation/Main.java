package one.digitalinnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinnovation.dominio.Bootcamp;
import one.digitalinnovation.dominio.Conteudo;
import one.digitalinnovation.dominio.Curso;
import one.digitalinnovation.dominio.Dev;
import one.digitalinnovation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		Curso cursoJava = new Curso();
		cursoJava.setTitulo("Java Básico");
		cursoJava.setDescricao("Aprenda conceitos básicos sobre Java.");
		cursoJava.setCargaHoraria(8);

		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo(".Net");
		cursoDotNet.setDescricao("Aprenda conceitos básicos sobre C#");
		cursoDotNet.setCargaHoraria(8);

		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda conceitos avançados sobre Java.");
		cursoJavaAvancado.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação à Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação à Objetos.");
		mentoria.setData(LocalDateTime.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJava, cursoDotNet, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);

		Dev beans = new Dev();
		beans.setNome("Beans");

		Dev blue = new Dev();
		blue.setNome("Blue");

		beans.inscrever(cursoDotNet);
		beans.inscrever(bootcamp);
		beans.progredir();
		beans.progredir();

		blue.inscrever(bootcamp);
		blue.progredir();
		blue.progredir();
		blue.progredir();
//		blue.progredir();

		System.out.println(String.format("XP %s: %.2f", beans.getNome(), beans.calcularTotalXp()));
		System.out.println(String.format("XP %s: %.2f", blue.getNome(), blue.calcularTotalXp()));

		List<Dev> ranking = Arrays.asList(beans, blue).stream()
				.sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
				.collect(Collectors.toList());
		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}
	}

}
