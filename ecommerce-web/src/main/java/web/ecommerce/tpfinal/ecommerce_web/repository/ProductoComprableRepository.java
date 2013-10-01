package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;

@Repository
@Transactional(readOnly = true)
public class ProductoComprableRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ProductoComprable> findAll() {
		TypedQuery<ProductoComprable> productoComprable = entityManager.createQuery("SELECT a from ProductoComprable a", ProductoComprable.class);
		List<ProductoComprable> productos = productoComprable.getResultList();
		
		return productos;
	}
	public void create(ProductoComprable productoComprable) {
		entityManager.persist(productoComprable);
	}
}
