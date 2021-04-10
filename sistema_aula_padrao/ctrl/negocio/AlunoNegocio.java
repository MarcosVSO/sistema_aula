package ctrl.negocio;

import java.util.List;

import ctrl.exception.AlunoException;
import model.dao.AlunoDAO;
import model.entities.Aluno;

public class AlunoNegocio {
	
	AlunoDAO dao = new AlunoDAO();
	
	//Inserir novo Aluno
	public Aluno inserir(Aluno aluno) throws AlunoException {
		dao.inserir(aluno);
		return aluno;
	}
	
	//Ler Aluno
	public List<Aluno> buscaTodos() throws AlunoException{
		return dao.buscaTodos();	
	}
	
	public Aluno buscaPorId(Integer id) throws AlunoException {
		return dao.buscaPorId(id);
	}
		
	//Update
	public Aluno alterar(Aluno aluno) throws AlunoException {		
		return dao.alterar(aluno);
	}
		
	//DELETE
	public void excluir(Integer id) throws AlunoException {
		dao.excluir(id);
	}
}
