package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;

@Repository
@Transactional(readOnly = true)
public class BusquedaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Producto> armarLista(String nombre, float minimo, float maximo){
		TypedQuery<Producto> prod = null;
		List<Producto> producto = new ArrayList<Producto>();
		if (nombre.equals("")){
			if (maximo != 0){
				prod = entityManager.createQuery("SELECT p from Producto p WHERE p.precio <= :maximo AND p.precio >= :minimo",Producto.class)
						.setParameter("minimo",minimo)
						.setParameter("maximo",maximo);
				producto = (prod.getResultList());
			}else {
				prod = entityManager.createQuery("SELECT p from Producto p WHERE p.precio >= :minimo",Producto.class)
						.setParameter("minimo",minimo);
				producto = (prod.getResultList());
			}
		}else {
			if (maximo != 0){
				prod = entityManager.createQuery("SELECT p from Producto p WHERE p.fabricante.nombre = :fabricante AND p.precio <= :maximo AND p.precio >= :minimo",Producto.class)
						.setParameter("fabricante",nombre)
						.setParameter("minimo",minimo)
						.setParameter("maximo",maximo);
				producto = (prod.getResultList());
			}else {
				prod = entityManager.createQuery("SELECT p from Producto p WHERE p.fabricante.nombre = :fabricante AND p.precio >= :minimo",Producto.class)
						.setParameter("fabricante",nombre)
						.setParameter("minimo",minimo);
				producto = (prod.getResultList());
			}
		}
	return producto;
	}
}
