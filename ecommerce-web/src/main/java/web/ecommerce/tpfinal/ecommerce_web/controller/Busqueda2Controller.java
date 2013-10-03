package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.repository.Busqueda2Repository;
import web.ecommerce.tpfinal.ecommerce_web.repository.FabricanteRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoRepository;

@Controller
@RequestMapping(value="/commerce/**")
public class Busqueda2Controller {
	
	@Autowired
	private Busqueda2Repository busqueda2Repository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired 
	private FabricanteRepository fabricanteRepository;
	
	
		@RequestMapping(value="/busqueda2", method=RequestMethod.GET)
		public ModelAndView busqueda2(){ //todosLosPoductos
			ModelAndView mav = new ModelAndView();
			mav.getModelMap().addAttribute("productos", productoRepository.findAll());
			//mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
			
			return mav;
		}
		
		/*@RequestMapping(value="/busqueda2",method=RequestMethod.GET)//busquedaXfabricante
		public ModelAndView busqueda2(@RequestParam int id){
			ModelAndView mav = new ModelAndView();
			
			mav.getModelMap().addAttribute("productos", busqueda2Repository.getPorFabricante(id));
			return mav;
		}*/
		
		/*@RequestMapping(value="/busqueda2",method=RequestMethod.GET)//busquedaPorNombre
		public ModelAndView busqueda3(@RequestParam int min,@RequestParam int max){
			ModelAndView mav = new ModelAndView();
			mav.getModelMap().addAttribute("productos", busqueda2Repository.getPorRango(min, max));
			return mav;
		}*/
}
