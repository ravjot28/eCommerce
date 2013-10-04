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
public class ProductoComprableRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(ProductoComprable productoComprable) {
		entityManager.persist(productoComprable);
	}
	
	public ProductoComprable get(long id){
		ProductoComprable productoComprable = entityManager.find(ProductoComprable.class, id);
		return productoComprable;	
	}

	public List<ProductoComprable> findAll() {
		TypedQuery<ProductoComprable> prod = entityManager.createQuery("SELECT a FROM ProductoComprable a", ProductoComprable.class);
		List<ProductoComprable> productos = prod.getResultList();	
		return productos;
	}
	
	//Producto producto, float precioPagado,int cantidad
	public ProductoComprable generar(Producto producto, int cantidad){
		ProductoComprable productoComprable = new ProductoComprable(producto, producto.getPrecio()*cantidad, cantidad);
		return productoComprable;
	}
}