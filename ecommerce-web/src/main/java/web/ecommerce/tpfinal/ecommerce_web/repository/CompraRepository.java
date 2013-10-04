package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Compra;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;

@Repository
@Transactional(readOnly = true)
public class CompraRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public List<Compra> findAll() {
		TypedQuery<Compra> compra = entityManager.createQuery("SELECT a from Compra a", Compra.class);
		List<Compra> compras = compra.getResultList();
		return compras;
	}
	
	public void create(Compra compra) {
		entityManager.persist(compra);
	}
	
	public int getIndex(ProductoComprable producto, List<ProductoComprable> lista){
		int index = -1;
		long idProducto = producto.getProducto().getId();
		for(ProductoComprable item : lista){
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
	
	public void agregarALista(ProductoComprable producto, Compra compra){
		compra.getProductos().add(producto);
	}
	
	public Compra getCompra(long id){
		Compra compra = entityManager.find(Compra.class, id);
		return compra;
	}
	
	public long buscarIdCompraDeCuenta(String email, List<Compra> lista){
		long idCompra = -1;
		for(Compra item : lista){
			if(item.getAccount().getEmail().equals(email)){
				if(item.isEstado() == true){
					idCompra = item.getId();
				}
			}
		}
		return idCompra;
	}

}