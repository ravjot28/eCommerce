package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;



@Repository
@Transactional(readOnly = true)
public class ProductoRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Producto> findAll() {
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT a from Producto a", Producto.class);
		List<Producto> productos = prod.getResultList();
		
		return productos;
	}
	public void create(Producto producto) {
		entityManager.persist(producto);
	}
	public Producto get(int id){
		Producto producto = entityManager.find(Producto.class, id);
		
		return producto;
		
	}
}


