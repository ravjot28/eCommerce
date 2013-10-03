/*package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.repository.Busqueda2Repository;
import web.ecommerce.tpfinal.ecommerce_web.repository.FabricanteRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoRepository;

@Controller
@RequestMapping(value="/buscar/**")
public class Busqueda2Controller {
	
	@Autowired
	private Busqueda2Repository busqueda2Repository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired 
	private FabricanteRepository fabricanteRepository;
	
	
		@RequestMapping(value="/busqueda2", method=RequestMethod.GET)
		public ModelAndView busqueda(){ //todosLosPoductos
			ModelAndView mav = new ModelAndView();
			ModelAndView mav2 = new ModelAndView();
			
			mav.getModelMap().addAttribute("productos", productoRepository.findAll());
			mav2.getModelMap().addAttribute("fabricantes",fabricanteRepository.getAllFabricantes());
			
			return mav;
		}
		
		@RequestMapping(value="",method=RequestMethod.GET)//busquedaXfabricante
		public ModelAndView busqueda(@RequestParam String nombre){
			ModelAndView mav = new ModelAndView();
			
			//mav.getModelMap().addAttribute("productos", busqueda2Repository.getPorFabricante(nombre));
			return mav;
		}
		
		@RequestMapping(value="",method=RequestMethod.GET)//busquedaPorNombre
		public ModelAndView busqueda(@RequestParam int min,@RequestParam int max){
			ModelAndView mav = new ModelAndView();
			mav.getModelMap().addAttribute("productos", busqueda2Repository.getPorRango(min, max));
			return mav;
		}
}*/
