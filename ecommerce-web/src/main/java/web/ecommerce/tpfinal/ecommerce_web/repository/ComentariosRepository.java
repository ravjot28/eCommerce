package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.jolbox.bonecp.BoneCPDataSource;


import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;


@Repository
@Transactional(readOnly = true)
public class ComentariosRepository {

	private DataSource ds;

	private ComentariosRepository(){
		ds = setupDataSource();
	}
	private static final ComentariosRepository INSTANCE = new ComentariosRepository(); 

	/* Private constructor prevents 
	 * instantiation from other classes */

	public static ComentariosRepository getInstance() { 
		return INSTANCE; 
	}

	public DataSource setupDataSource() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		String url = "jdbc:mysql://localhost/ecommerce-web";
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
	private static final Logger LOG = LoggerFactory.getLogger(ComentariosRepository.class);


	@PersistenceContext
	private EntityManager entityManager;


	public List<Comentario> findAll(int id){
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario c", Comentario.class);
		List<Comentario> comentarios = q.getResultList();
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());

		return comentarios;
	}
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	public void block(int numeroComentario){
		if(get(numeroComentario).isAceptado()){
			get(numeroComentario).setAceptado(false);
		}else{
			get(numeroComentario).setAceptado(true);
		}
	}
	public void delete(int numeroComentario){
		entityManager.remove(numeroComentario);
	}
	public Comentario save(Comentario comentario){
		comentario.setTexto(comentario.getTexto());		
		entityManager.persist(comentario);
		return null;

	}
	public Comentario get(int numeroComentario){
		Comentario comentarios = entityManager.find(Comentario.class, numeroComentario);
		return comentarios;
	}
}

