package web.ecommerce.tpfinal.ecommerce_web.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;

import com.jolbox.bonecp.BoneCPDataSource;

@Repository
@Transactional(readOnly = true)
public class FabricanteRepository {
			
		public DataSource setupDataSource() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			String url = "jdbc:mysql://localhost/ecommerce";
			String user = "root";
			String password = "";

			// Class.forName("org.hsqldb.jdbcDriver"); 	// load the DB driver
			BoneCPDataSource ds = new BoneCPDataSource();  // create a new datasource object
		 	ds.setJdbcUrl(url);		// set the JDBC url
			ds.setUsername(user);				// set the username
			ds.setPassword(password);				// set the password
			ds.setMinConnectionsPerPartition(5);
			
			return ds;
		}
		
		
		@PersistenceContext
		private EntityManager entityManager;
		
		public List<Fabricante> getAllFabricantes(){
			TypedQuery<Fabricante> fab = entityManager.createQuery("SELECT f FROM Fabricante",Fabricante.class);
			List<Fabricante> fabricantes = fab.getResultList();
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
		public Fabricante getF(int id){
			Fabricante fabricante=null;
			fabricante=entityManager.find(Fabricante.class, id);
			return fabricante;
		}
		public void deleteF(int id){
			Fabricante fabricante=getF(id);
			entityManager.remove(fabricante);
			entityManager.flush();
			
		}
		public void saveF(Fabricante fabricante){
			entityManager.merge(fabricante);
			entityManager.flush();
		}

}
