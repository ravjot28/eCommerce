package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountController;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;


@Repository
@Transactional(readOnly = true)
public class ProductoRepository {
	
	private static final Logger LOG = LoggerFactory
			.getLogger(AccountController.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Producto> findAll() {
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT a FROM Producto a", Producto.class);
		List<Producto> productos = prod.getResultList();
		
		return productos;
	}
		
	
	public ArrayList<Producto> getPorFabricantePrecio(double precio){
		TypedQuery<Producto> prod = entityManager.createQuery("SELECT fabricante.nombre, producto.nombre, producto.precio FROM Producto, Fabricante WHERE producto.fabricante_id=fabricante.id INNER JOIN Fabricante ON producto.fabricante_id=fabricante.id ",Producto.class);
		ArrayList<Producto> productos = (ArrayList<Producto>) prod.getResultList();
		
		return productos;
	}
	
	
	public List<Producto> getAll() {
		TypedQuery<Producto> q = entityManager.createQuery(
				"select p from Producto p", Producto.class);
		List<Producto> productos = q.getResultList();
		LOG.info("Se obtuvieron {} productos", productos.size());

		return productos;
	}

	public void createP(Producto producto) {
		entityManager.persist(producto);

	}

	public Producto getP(Long id) {
		Producto producto = null;
		producto = entityManager.find(Producto.class, id);
		return producto;
	}

	public void deleteP(Long id) {
		Producto producto= getP(id);
		entityManager.remove(producto);
		entityManager.flush();
	
	}

	public void saveP(Producto producto) {
		entityManager.merge(producto);
		entityManager.flush();
		
	}
	
}



