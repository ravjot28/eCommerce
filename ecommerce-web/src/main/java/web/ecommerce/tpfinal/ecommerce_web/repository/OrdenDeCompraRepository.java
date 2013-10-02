package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Compra;

@Repository
@Transactional(readOnly = true)
public class OrdenDeCompraRepository {
	
	
	/************************************************************************************************************/
	
	/*************************************************************************************************************/


	@PersistenceContext
	private EntityManager entityManager;
	
	//Carga los changuitos a la base de datos a la tabla compra.
	public void cargarChanguitoDB(Compra compra){
		entityManager.persist(compra);
	}

	/*************************************************************************************************************/
	//Extrae los datos de la base de datos de la tabla compra en una lista.
	public List<Compra> extraerCompras(){
		TypedQuery<Compra> q = entityManager.createQuery("select a from Compra c", Compra.class);
		List<Compra> compras = q.getResultList();

		return compras;
	}

	//Carga datos a la tabla compraVerificadas.
	public void cargarCompras(Compra compra){
		entityManager.persist(compra);
	}

	//Extrae los datos de la tabla Comprasverificadas.
	public List<Compra> extraerUsuarios(){
		TypedQuery<Compra> q = entityManager.createQuery("select a from Compra c", Compra.class);
		List<Compra> usuarios = q.getResultList();

		return usuarios;
	}

}
