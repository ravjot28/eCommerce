/*Este controller se utiliza para las relaciones entre las siguientes clases y los siguientes jsp:
 * - OrdenDeCompraRepository.java (contiene las consultas a la base de datos)
 * - admin.jsp/adminconfimrado.jsp/user.jsp (El controller se encarga de darles las vitas para que puedan ser mostrados en un navegador y
 * tambien les da funcionalidades ya sea como: crear, modificar, updatear y eliminar datos)*/

/*import*/
package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Compra;
import web.ecommerce.tpfinal.ecommerce_web.repository.OrdenDeCompraRepository;


/*Clase controller*/
@Controller
@RequestMapping(value="/ordendecompra/**")
public class UserAdminController {
	
	//utilizado para poder interactuar con la bse de datos
	@Autowired
	private OrdenDeCompraRepository ordenDeCompraRepository;

	/***************************************************************************************************************************************
	 * Funcionalidades dada al grupo de Compra
	 **************************************************************************************************************************************/
	
	/*Este metodo permite ser cargado por un jsp para cargar(meter) en la base de datos "Compra" los datos
	 * de un objeto
	@RequestMapping(value="crearChanguito"accion, method=RequestMethod.POST)
	public ModelAndView crearChanguito(@ModelAttribute Compra compra){
		ModelAndView mav = new ModelAndView();
		
		ordenDeCompraRepository.cargarChanguitoDB(compra);//llama a ordenDeCompraRepository.cargarChanguitoDB() para cargar un objeto
		return mav;
	}
	
	/**************************************************************************************************************************************/
	
	
	
	
	
	/***************************************************************************************************************************************
	 * Funcionalidades para nuestros "jsp" -admin.jsp -adminconfirmado.jsp -user.jsp
	 **************************************************************************************************************************************/
  
	/*crea la vista del admin*/
	@RequestMapping(value="admin", method=RequestMethod.GET)
	public ModelAndView vistaAdmin(){
		ModelAndView mav = new ModelAndView();

		mav.getModelMap().addAttribute("compras", ordenDeCompraRepository.extraerCompras());
		return mav;
	}

	/*crea la vista del adminconfirmado*/
	@RequestMapping(value="adminconfirmado", method=RequestMethod.GET)
	public ModelAndView vistaAdminconfirmado(){
		ModelAndView mav = new ModelAndView();


		mav.getModelMap().addAttribute("compras", ordenDeCompraRepository.extraerComprasConfirmadas());
		return mav;
	}

	/*Obtiene los datos del admin.jsp y actualiza la tabla "Compras"*/
	@RequestMapping(value="verificarCompras", method=RequestMethod.POST)
	public ModelAndView verificarCompras(@RequestParam long id, @RequestParam String estadoCompra){
		ModelAndView mav = new ModelAndView("redirect:/ordendecompra/admin");

		ordenDeCompraRepository.cargarCompras(id,estadoCompra);
		return mav;
	}

	
	
	
	/***************************************************************************************************************************************
	 * Funcionalidades para nuestros "jsp" -user.jsp
	 **************************************************************************************************************************************/
	
	/*Crea la vista del user*/
	@RequestMapping(value="user", method=RequestMethod.GET)
	public ModelAndView vistaUser(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	/*Crea la vista del user*/
	@RequestMapping(value="user2", method=RequestMethod.GET)
	public ModelAndView vistaUser2(@RequestParam String email){
		ModelAndView mav = new ModelAndView();

		mav.getModelMap().addAttribute("compras", ordenDeCompraRepository.extraerComprasDeUsuario(email));

		return mav;
	}

	/*Consulta en base a un email dado todas las compras que realizo ese usuario*/
	@RequestMapping(value="consultarComprasUser", method=RequestMethod.GET)
	public ModelAndView consultarComprasUser(@RequestParam String email){
		ModelAndView mav = new ModelAndView("redirect:user2");

		mav.getModelMap().addAttribute("email", email);
		
		return mav;
	}
	
	
}
