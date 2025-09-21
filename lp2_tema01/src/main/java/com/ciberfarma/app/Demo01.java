package com.ciberfarma.app;

import com.ciberfarma.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo01 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Producto p = new Producto();
			
			p.setId_prod("P002");
			p.setDes_prod("Producto ejemplo 2");
			p.setStk_prod(66);
			p.setPre_prod(08.50);
			p.setIdcategoria(1);
			p.setIdproveedor(1);
			//p.setEst_prod(0);
			
			em.getTransaction().begin();;
			em.persist(p);
			em.getTransaction().commit();
			
			System.out.println("Producto registrado correctamente");
		} catch(Exception e) {
			
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			
			em.clear();
			emf.close();
		}
	}

}
