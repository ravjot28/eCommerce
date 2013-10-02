package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;


@Repository
@Transactional(readOnly = true)
public class Busqueda2Repository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Producto> getPorFabricante(int id){
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT p from Producto WHERE p.id = :id",Producto.class)
				.setParameter(":id",1);
		List<Producto> productos = prod.getResultList();
		return productos;
	}
	
	public List <Producto> getPorPrecio(double precio){
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT a from Producto WHERE precio >= precio",Producto.class);
		List<Producto> productos = prod.getResultList();
		return productos;
	}
	
	public List <Producto> getPorRango(double min, double max){
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT a from Producto WHERE precio >= min AND precio <= max",Producto.class);
		List<Producto> productos = prod.getResultList();
		return productos;
	}
	
}
