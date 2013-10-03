package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;

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

}
