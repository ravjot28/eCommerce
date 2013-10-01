package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;


@Repository
@Transactional(readOnly = true)
public class CarritoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
}
