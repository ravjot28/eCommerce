package web.ecommerce.tpfinal.ecommerce_web.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.account.AccountController;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;




@Repository
@Transactional(readOnly = true)
public class FabricanteRepository {
		private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);	
		
		
		@PersistenceContext
		private EntityManager entityManager;
		
		public List<Fabricante> getAllFabricantes(){
			TypedQuery<Fabricante> q = entityManager.createQuery("select f from Fabricante f", Fabricante.class);
			List<Fabricante> fabricantes = q.getResultList();
			LOG.info("Se obtuvieron {} fabricantes", fabricantes.size());

			return fabricantes;
		}
		
		public List<Producto> getAllProdFab(Fabricante fabricante) {
			TypedQuery<Producto> q = entityManager.createQuery("select p from Producto p where p.fabricante.id = :id", Producto.class)
					.setParameter("id", fabricante.getId());

			List<Producto> productos = q.getResultList();
			System.out.println(productos.size());
			return productos;
		}
			
		
		public void createF(Fabricante fabricante) {
			entityManager.persist(fabricante);
		}
		public Fabricante getF(Long id){
			Fabricante fabricante=null;
			fabricante=entityManager.find(Fabricante.class, id);
			return fabricante;
		}
		public void deleteF(Long id){
			Fabricante fabricante=getF(id);
			entityManager.remove(fabricante);
			entityManager.flush();
			
		}
		public void saveF(Fabricante fabricante){
			entityManager.merge(fabricante);
			entityManager.flush();
		}

}
