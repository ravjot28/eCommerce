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
	
	public List <Producto> getFiltroCompleto(float min, float max,long id){
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT p FROM Producto p WHERE p.precio BETWEEN :min AND :max AND p.fabricante.id = :id",Producto.class)
				.setParameter("min",min).setParameter("max", max).setParameter("id", id);
		List<Producto> productos = prod.getResultList();
		return productos;
	}
	
}
