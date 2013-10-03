package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;
//import web.ecommerce.tpfinal.ecommerce_web.controller.ComentarioController;


@Repository
@Transactional(readOnly = true)
public class ComentariosRepository {
	private static final Logger LOG = LoggerFactory.getLogger(ComentariosRepository.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Comentario> findAll(int id){
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario a", Comentario.class);
		List<Comentario> comentarios = q.getResultList();
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());

		return comentarios;
	}
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	public void block(int id){
		System.out.println("tengo un; "+get(id).isAceptado());
		if(get(id).isAceptado()){
			System.out.println("intento transformar un ; "+get(id).isAceptado());
			get(id).setAceptado(false);
			System.out.println("lo deje en; "+get(id).isAceptado());
		}else{
			System.out.println("intento transformar un ; "+get(id).isAceptado());
			get(id).setAceptado(false);
			System.out.println("lo deje en; "+get(id).isAceptado());
		}
		save(get(id));
	}
	public void delete(int numeroComentario){
		entityManager.remove(numeroComentario);
	}
	public void save(Comentario comentario){
		comentario.setTexto(comentario.getTexto());		
		//entityManager.persist(comentario);
		entityManager.merge(comentario);
		entityManager.getTransaction().commit();
	}
	public Comentario get(int numeroComentario){
		Comentario comentarios = entityManager.find(Comentario.class, numeroComentario);
		return comentarios;
	}
}

