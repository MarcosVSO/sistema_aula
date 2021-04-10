package br.ufg.inf.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.AlunoCtrl;
import br.ufg.inf.ctrl.CursoCtrl;
import br.ufg.inf.ctrl.DisciplinaCtrl;
import br.ufg.inf.ctrl.MatriculaCtrl;
import br.ufg.inf.ctrl.OfertaCtrl;
import br.ufg.inf.ctrl.PessoaCtrl;
import br.ufg.inf.ctrl.ProfessorCtrl;
import br.ufg.inf.ctrl.exception.AlunoException;
import br.ufg.inf.model.entities.Aluno;
import br.ufg.inf.model.entities.Curso;
import br.ufg.inf.model.entities.Disciplina;
import br.ufg.inf.model.entities.Matricula;
import br.ufg.inf.model.entities.Oferta;
import br.ufg.inf.model.entities.Pessoa;
import br.ufg.inf.model.entities.Professor;
import br.ufg.inf.model.enums.Dia;
import br.ufg.inf.model.enums.Escolaridade;

public class Aplication {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Executando!!!");
		testeMatricula();
		System.out.println("Concluindo");
	}
	
	
	public static void testeOferta() {
		
		OfertaCtrl ctrl = new OfertaCtrl();
		ProfessorCtrl professorCtrl = new ProfessorCtrl();
		DisciplinaCtrl disciplinaCtrl = new DisciplinaCtrl();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Oferta ofe1 = new Oferta(null, 
						professorCtrl.buscaPorId(1), 
						disciplinaCtrl.buscaPorId(2), 
						simpleDateFormat.parse("02/02/2021"), 
						simpleDateFormat.parse("15/06/2021"), 
						Dia.SEGUNDA, 
						"08:00");
			
			Oferta ofe2 = new Oferta(null, 
					professorCtrl.buscaPorId(2), 
					disciplinaCtrl.buscaPorId(3), 
					simpleDateFormat.parse("02/02/2021"), 
					simpleDateFormat.parse("15/06/2021"), 
					Dia.QUARTA, 
					"14:00");
			
			Oferta ofe3 = new Oferta(null, 
					professorCtrl.buscaPorId(3), 
					disciplinaCtrl.buscaPorId(4), 
					simpleDateFormat.parse("02/02/2021"), 
					simpleDateFormat.parse("15/06/2021"), 
					Dia.SEXTA, 
					"19:00");
			
			ctrl.inserir(ofe1);
			ctrl.inserir(ofe2);
			ctrl.inserir(ofe3);
			
			Oferta oferta = ctrl.buscaPorId(1);
			oferta.setDtInicio(simpleDateFormat.parse("22/02/2021"));
			
			ctrl.alterar(oferta);
			
			
			
			for(Oferta o : ctrl.buscaTodos()) {
				System.out.println(o);
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testeProfessor() {
		
		ProfessorCtrl ctrl = new ProfessorCtrl();
		PessoaCtrl pessoaCtrl = new PessoaCtrl();
		
		/*Professor prof1 = new Professor(null, pessoaCtrl.buscaPorId(1), Escolaridade.MESTRADO);
		Professor prof2 = new Professor(null, pessoaCtrl.buscaPorId(2), Escolaridade.MEDIO);
		Professor prof3 = new Professor(null, pessoaCtrl.buscaPorId(3), Escolaridade.DOUTORADO);
		
		ctrl.inserir(prof1);
		ctrl.inserir(prof2);
		ctrl.inserir(prof3);
		*/
		
		Professor prof1 = ctrl.buscaPorId(1);
		
		prof1.setEscolaridade(Escolaridade.GRADUACAO);
		ctrl.alterar(prof1);
		
		
	}
	
	
	public static void testePessoa() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		
		PessoaCtrl ctrl = new PessoaCtrl();
		try {
			
			//Pessoa pes1 = new Pessoa(null, "Luiz", 12345678901l, simpleDateFormat.parse("01-01-1990"));
			//ctrl.inserir(pes1);
	
			//Pessoa pes2 = new Pessoa(null, "Fulano", 11111111111l, simpleDateFormat.parse("01-01-1990"));
			//ctrl.inserir(pes2);
	
			//Pessoa pes3 = new Pessoa(null, "Beltrano", 22222222222l, simpleDateFormat.parse("01-01-1990"));
			//ctrl.inserir(pes3);
	
			//Pessoa pes4 = new Pessoa(null, "Cicrano", 33333333333l, simpleDateFormat.parse("01-01-1990"));
			//ctrl.inserir(pes4);
	
			
			Pessoa pes1 = ctrl.buscaPorId(2);
			
			pes1.setDtNascimento(simpleDateFormat.parse("01-01-1990"));

		
			ctrl.alterar(pes1);
			
			Pessoa pes2 = ctrl.buscaPorId(2);
			pes2.setDtNascimento(simpleDateFormat.parse("01-04-2000"));
			ctrl.alterar(pes2);

			Pessoa pes3 = ctrl.buscaPorId(3);
			pes3.setDtNascimento(simpleDateFormat.parse("15-06-2005"));
			ctrl.alterar(pes3);
			
			Pessoa pes4 = ctrl.buscaPorId(4);
			pes4.setDtNascimento(simpleDateFormat.parse("30-09-2015"));
			ctrl.alterar(pes4);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void testeCtrl() {
		
		DisciplinaCtrl ctrl = new DisciplinaCtrl();
		Disciplina disciplina = new Disciplina(null, "Banco de Dados", 64);
		
		//ctrl.inserir(disciplina);
		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" - Alterada");
		//ctrl.alterar(disciplina);
		System.out.println(ctrl.buscaPorId(3));
		for(Disciplina d : ctrl.buscaTodos()) {
			System.out.println(d);
		}
		System.out.println("-----------------------------------");
		for(Disciplina d : ctrl.buscaPorNome("Banco")) {
			System.out.println(d);
		}
	}
	
	
	public void testeJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		Disciplina disc1 = new Disciplina(null, "FullStack", 64);
		Disciplina disc2 = new Disciplina(null, "Matemática", 88);
		Disciplina disc3 = new Disciplina(null, "Java", 30);
		Disciplina disc4 = new Disciplina(null, "TypeScript", 90);
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");	
		//em.getTransaction().begin();
		//em.persist(disc1);
		//em.persist(disc2);
		//em.persist(disc3);
		//em.persist(disc4);
		//em.getTransaction().commit();
		
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");
		//System.out.println("Acabou!");
		
		
		TypedQuery<Disciplina> query =  em.createQuery("from Disciplina", Disciplina.class);
		List<Disciplina> disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas Cadatradas---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		
		Disciplina disciplina = em.find(Disciplina.class, 2);
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		

		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" ALTERADO");
		
		em.getTransaction().begin();
		em.persist(disciplina);
		em.getTransaction().commit();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2 Alterado---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		
	
		String str = "ll";
		
		String sql = "from Disciplina d where d.nmDisciplina like :str";
		query = em.createQuery(sql, Disciplina.class);
		query.setParameter("str", "%"+str+"%");
		disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas com "+str+"---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		Disciplina excluir = em.find(Disciplina.class, 1);
		System.out.println(excluir);
	//	em.getTransaction().begin();
	//	em.remove(excluir);
	//	em.getTransaction().commit();
		
	}
	
	public static void testeCurso() {
		CursoCtrl ctrl = new CursoCtrl();
		
		// Mostrar todos os cursos
		System.out.println(ctrl.buscaTodos());
		
		//Criando cursos para inserção
		Curso curso1 = new Curso(null,"Filosofia");
		Curso curso2 = new Curso(null,"Matemática");
		Curso curso3 = new Curso(null,"Pedagogia");
		
		//Inserindo Cursos
		ctrl.inserir(curso1);
		ctrl.inserir(curso2);
		ctrl.inserir(curso3);
		
		// Mostrar todos os cursos
		System.out.println(ctrl.buscaTodos());
		
		//Alterando Pedagogia para Geografia
		curso3.setNmCurso("Geografia");
		ctrl.alterar(curso3);
		
		// Mostrar todos os cursos
		System.out.println(ctrl.buscaTodos());
		
		//Deletar Sistemas Informação
		List<Curso> listaCursos = null;
		listaCursos = ctrl.buscaTodos();
		int idSI = 0;
		for (Curso curso : listaCursos) {
			if (curso.getNmCurso().equals("Sistemas de Informação")) {
				idSI = curso.getIdCurso();
			}
		}
		ctrl.excluir(idSI);
		
		System.out.println(ctrl.buscaTodos());

	}

	public static void testeAluno(){
		AlunoCtrl ctrl = new AlunoCtrl();
		PessoaCtrl ctrlPessoa = new PessoaCtrl();
		CursoCtrl ctrlCurso = new CursoCtrl();
		
		Pessoa pessoa1 = ctrlPessoa.buscaPorId(5);
		Pessoa pessoa2 = ctrlPessoa.buscaPorId(6);
		Pessoa pessoa3 = ctrlPessoa.buscaPorId(8);
		
		Curso curso1 = ctrlCurso.buscaPorId(13);
		Curso curso2 = ctrlCurso.buscaPorId(15);
		Curso curso3 = ctrlCurso.buscaPorId(17);
		
		Aluno aluno1 = new Aluno(null,new Date(2020,01,01),true,pessoa1,curso1);
		Aluno aluno2 = new Aluno(null,new Date(2020,06,03),true,pessoa2,curso2);
		Aluno aluno3 = new Aluno(null,new Date(2021,04,01),true,pessoa3,curso3);
		
		try {
			//Inserindo Alunos
			ctrl.inserir(aluno1);
			ctrl.inserir(aluno2);
			ctrl.inserir(aluno3);
			System.out.println(ctrl.buscaTodos());
			
			//Modificando Aluno
			aluno2.setDtInicio(new Date(2021, 1, 2));
			ctrl.alterar(aluno3);
			System.out.println(ctrl.buscaTodos());
			
			//Excluir Aluno Último Cadastrado
			List<Aluno> alunos = null;
			alunos = ctrl.buscaTodos();
			Aluno ultimoAluno = null;
			for (Aluno aluno : alunos) {
				ultimoAluno = aluno;
			}
			ctrl.excluir(ultimoAluno.getIdAluno());
		} catch (AlunoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void testeMatricula(){
		MatriculaCtrl ctrl = new MatriculaCtrl();
		AlunoCtrl alunoCtrl = new AlunoCtrl();
		OfertaCtrl ofertaCtrl = new OfertaCtrl();
		
		try {
			Aluno aluno1 = alunoCtrl.buscaPorId(39);
			Aluno aluno2 = alunoCtrl.buscaPorId(40);
			
			Oferta oferta1 = ofertaCtrl.buscaPorId(12);
			Oferta oferta2 = ofertaCtrl.buscaPorId(13);
			Oferta oferta3 = ofertaCtrl.buscaPorId(14);
			
			Matricula matricula1 = new Matricula(null,aluno1,oferta1);
			Matricula matricula2 = new Matricula(null,aluno2,oferta2);
			
			//Inserindo matriculas
			ctrl.inserir(matricula1);
			ctrl.inserir(matricula2);
			System.out.println(ctrl.buscaTodos());
			
			//Alterando Matricula2
			matricula2.setOferta(oferta3);
			ctrl.alterar(matricula2);
			System.out.println(ctrl.buscaTodos());
			
			//Excluindo Oferta1
			ctrl.excluir(3);
			System.out.println(ctrl.buscaTodos());
		} catch (AlunoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
