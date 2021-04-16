package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Aluno;
import br.ufg.inf.fullstack.model.repositories.AlunoRepository;

@Service
public class AlunoBusiness {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer id) {
		Optional<Aluno> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Aluno insert(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Aluno alunoUpd) {
		Aluno aluno = repository.findById(alunoUpd.getIdAluno()).get();
		aluno.setAtivo(alunoUpd.getAtivo());
		aluno.setCurso(alunoUpd.getCurso());
		aluno.setDtInicio(aluno.getDtInicio());
		aluno.setPessoa(alunoUpd.getPessoa());
		return repository.save(aluno);
	}
}
