package com.ciberfarma.app;

import com.ciberfarma.model.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo02 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Categoria cat = new Categoria();
			cat.setDescripcion("Electrodomestico");
			
			em.getTransaction().begin();;
			em.persist(cat);
			em.getTransaction().commit();
			
			System.out.println("Categoria registrado correctamente");
		} catch(Exception e) {
			
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			
			em.clear();
			emf.close();
		}
	}

}
