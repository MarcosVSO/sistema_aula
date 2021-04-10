package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.ctrl.negocio.CursoNegocio;
import br.ufg.inf.model.entities.Curso;

public class CursoCtrl {

	CursoNegocio negocio = new CursoNegocio();
	
	public Curso inserir(Curso curso) {
		try {
			curso = negocio.inserir(curso);
			System.out.println("Curso cadastrado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar cadastrar Curso.");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public List<Curso> buscaTodos() {
		List<Curso> cursos = null;
		try {
			cursos = negocio.buscaTodos();
		} catch (CursoException e) {
			System.out.println("Erro tentar buscar as cursos cadastradas.");
			System.out.println(e.getMessage());
		}
		return cursos;
	}
	
	public Curso buscaPorId(Integer id) {
		Curso curso = null;
		try {
			curso = negocio.buscaPorId(id);
		} catch (CursoException e) {
			System.out.println("Erro tentar buscar Curso do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public Curso alterar(Curso curso) {
		try {
			curso = negocio.alterar(curso);
			System.out.println("Curso alterado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar alterar Curso com ID: " + curso.getIdCurso() + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}
	
	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Curso excluída com sucesso.");
		} catch (CursoException e) {
			System.out.println("Erro ao tentar excluir a curso");
			System.out.println(e.getMessage());
		}
	}

	
}
