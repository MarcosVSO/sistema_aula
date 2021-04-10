package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.model.dao.CursoDAO;
import br.ufg.inf.model.entities.Curso;


public class CursoNegocio {
	CursoDAO dao = new CursoDAO();

	//Inserir novo Curso
		public Curso inserir(Curso curso) throws CursoException {
			dao.inserir(curso);
			return curso;
		}
		
		//Ler Cursos
		public List<Curso> buscaTodos() throws CursoException{
			return dao.buscaTodos();	
		}
		
		public Curso buscaPorId(Integer id) throws CursoException {
			return dao.buscaPorId(id);
		}
		
		//Update
		public Curso alterar(Curso curso) throws CursoException {		
			return dao.alterar(curso);
		}
		
		//DELETE
		public void excluir(Integer id) throws CursoException {
			dao.excluir(id);
		}
}
