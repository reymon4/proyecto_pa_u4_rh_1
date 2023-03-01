package com.example.demo.repository;

import java.util.List;


import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Persona;
import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepoImpl implements IPersonaRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		Query query = this.em.createNativeQuery("Select * from persona", Persona.class);
		return query.getResultList();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.em.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.em.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona per = this.buscarPorId(id);
		this.em.remove(per);
	}

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.em.persist(persona);
	}

}
