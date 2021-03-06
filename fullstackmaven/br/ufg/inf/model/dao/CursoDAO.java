package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.model.entities.Curso;

public class CursoDAO {
	EntityManager em = DaoFactory.getEntityManager();
	
	//CREATE
	public Curso inserir(Curso curso) throws CursoException {
		this.em.getTransaction().begin();
		this.em.persist(curso);
		this.em.getTransaction().commit();
		return curso;
	}
	
	// READ
	public List<Curso> buscaTodos() throws CursoException {
		return this.em.createQuery("from Curso", Curso.class).getResultList();
	}

	public Curso buscaPorId(Integer id) throws CursoException {
		return this.em.find(Curso.class, id);
	}
	
	// UPDATE
	public Curso alterar(Curso curso) throws CursoException {
		this.em.getTransaction().begin();
		this.em.persist(curso);
		this.em.getTransaction().commit();
		return curso;
	}
	
	// DELETE
	public void excluir(Integer id) throws CursoException {
		this.em.remove(this.buscaPorId(id));
	}
}
