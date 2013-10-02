package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.controller.ProductoRepository;

@Repository
@Transactional(readOnly = true)
public class ProductoComprableRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(ProductoComprable productoComprable) {
		entityManager.persist(productoComprable);
	}
}
