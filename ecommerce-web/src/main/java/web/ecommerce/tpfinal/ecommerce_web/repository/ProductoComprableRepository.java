package web.ecommerce.tpfinal.ecommerce_web.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;

@Repository
@Transactional(readOnly = true)
public class ProductoComprableRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(ProductoComprable productoComprable) {
		entityManager.persist(productoComprable);
	}
}
