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
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario a where idProducto = :id", Comentario.class)
				.setParameter("id", id);
		List<Comentario> comentarios = q.getResultList();
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());
		return comentarios;
	}
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	public void block(int id){
		Comentario unCometnario = get(id);
		if(unCometnario.isAceptado()){
			System.out.println("ENTRO EN EL IF");
			unCometnario.setAceptado(false);
		}else{
			System.out.println("ENTRO EN EL else");
			unCometnario.setAceptado(true);
		}
		save(unCometnario);
		System.out.println("salio");
	}
	public void delete(int id){
		System.out.println("entro en el remove");
		entityManager.remove(get(id));
		entityManager.flush();
	}
	public Comentario save(Comentario unComentario){
		Comentario elComentario = get(unComentario.getId());
		elComentario.setTexto(unComentario.getTexto());
		elComentario.setAceptado(unComentario.isAceptado());
		entityManager.flush();
		System.out.println("entro en el save");
		return elComentario;

	}
	public Comentario get(int id){
		System.out.println("entro en el get");
		Comentario comentarios = entityManager.find(Comentario.class, id);
		return comentarios;
	}
}

