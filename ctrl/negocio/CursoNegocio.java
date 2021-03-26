package ctrl.negocio;

import java.util.List;

import ctrl.exception.CursoException;
import model.dao.CursoDAO;
import model.entities.Curso;

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
