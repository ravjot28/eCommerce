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
			List<Producto> productos = productoRepository.findAll();
			mav.getModelMap().addAttribute("productos", productos);
			mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
			
			return mav;
		}
		
		
		@RequestMapping(value="resultado2", method=RequestMethod.POST)//busqueda xPyN
		public ModelAndView resultado2(@RequestParam float min,@RequestParam float max,@RequestParam long id){
			ModelAndView mav = new ModelAndView();
			mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
			mav.getModelMap().addAttribute("productos",
				busqueda2Repository.getFiltroCompleto(min, max, id));
			
			return mav;
		}
}
