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
		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java B�sico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos b�sicos sobre Java.");
		cursoJavaBasico.setCargaHoraria(8);
		
		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("Java .NET");
		cursoDotNet.setDescricao("Aprenda os conceitos b�sicos sobre C#.");
		cursoDotNet.setCargaHoraria(8);
		
		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avan�ado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avan�ados sobre Java.");
		cursoJavaAvancado.setCargaHoraria(8);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orienta��o a Objetos com Java");
		mentoria.setDescricao("Imers�o sobre os pilares da Orienta��o a Objetos.");
		mentoria.setData(LocalDateTime.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);
		
		Dev wagner = new Dev();
		wagner.setNome("Wagner");
		
		Dev jean = new Dev();
		jean.setNome("Jean");
		
		wagner.inscrever(cursoDotNet);
		wagner.inscrever(bootcamp);
		wagner.progredir();
		wagner.progredir();
		
		jean.inscrever(bootcamp);
		jean.progredir();
		jean.progredir();
		jean.progredir();

		System.out.println(String.format("XP Wagner: %.2f", wagner.calcularTotalXp()));
		System.out.println(String.format("XP jean: %.2f", jean.calcularTotalXp()));
		
		List<Dev> ranking = Arrays.asList(wagner, jean).stream()
								  .sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
								  .collect(Collectors.toList());
		
		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}
	}

}
