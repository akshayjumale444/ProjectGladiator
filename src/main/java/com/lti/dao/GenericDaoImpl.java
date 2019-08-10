package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository		
public class GenericDaoImpl implements GenericDao{

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public Object save(Object obj){
		return entityManager.merge(obj);
	}

	public <E> E fetchById(Class <E> clazz, Object pk){
		return entityManager.find(clazz, pk);
	}

	public <E> List<E> fetchAll(Class<E> clazz){
		String q="select obj from "+clazz.getName()+" as obj";
		return entityManager.createQuery(q).getResultList();
	}

}
