package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.ctrl.exception.CursoException;
import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.repositories.CursoRepository;

@Service
public class CursoBusiness {
	
	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(Integer id) throws CursoException {
		Optional<Curso> retorno = repository.findById(id);
		if(retorno.isEmpty()) {
			throw new CursoException("0112");
		}
		return retorno.get();
	}
	
	public Curso insert(Curso curso) throws CursoException {
		return repository.save(curso);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Curso update(Curso curso) throws CursoException {
		Curso cursoUpd = repository.findById(curso.getIdCurso()).get();
		cursoUpd.setNmCurso(curso.getNmCurso());
		return repository.save(cursoUpd);
	}
	
	public List<Curso> findByNmCurso(String name) throws CursoException{
		List<Curso> retorno =  repository.findByNmCurso(name);
		if(retorno.isEmpty()) {
			throw new CursoException("0113");
		}
		return retorno;
	}
}
