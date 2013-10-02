/*package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Compra;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;


@Repository
@Transactional(readOnly = true)
public class CompraRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ProductoRepository productosRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private ProductoComprableRepository productosComprablesReporsitory;
	
	public List<ProductoComprable> findAll() {
		TypedQuery<ProductoComprable> productoComprable = entityManager.createQuery("SELECT a from ProductoComprable a", ProductoComprable.class);
		List<ProductoComprable> productos = productoComprable.getResultList();
		return productos;
	}
	
	public void create(Compra compra) {
		entityManager.persist(compra);
	}
	
	public ProductoComprable get(int id, int cantidad){
		//Producto producto, float precioPagado, int cantidad
		Producto producto = productosRepository.get(id);
		ProductoComprable productoComprable = new ProductoComprable(producto, producto.getPrecio(), cantidad);
		return productoComprable;
	}
	
	public int getIndex(ProductoComprable producto){
		int index = -1;
		int idProducto = producto.getProducto().getId();
		for(ProductoComprable item : compraRepository.findAll()){
			if(item.getProducto().getId() != idProducto){
				index++;
			}
		}
		return index+1;
	}
	
	public boolean getEstado(){
		boolean estado;
		Compra compra = entityManager.find(Compra.class, 0);
		estado = compra.isEstado();
		return estado;
	}
	
	public void agregarALista(ProductoComprable producto){
		List<ProductoComprable> lista = compraRepository.findAll();
		lista.add(producto);
	}
	
}*/
