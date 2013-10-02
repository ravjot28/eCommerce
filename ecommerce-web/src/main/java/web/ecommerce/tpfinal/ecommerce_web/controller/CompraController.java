package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.repository.CompraRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoComprableRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoRepository;

public class CompraController {
	@Controller
	@RequestMapping(value="/commerce/**")
	public class CommerceController {
		
		@Autowired
		private ProductoComprableRepository productoComprableRepository;
		
		@Autowired
		private CompraRepository compraRepository;
		
		@Autowired
		private ProductoRepository productoRepository;
		
		@RequestMapping(value="/carrito", method=RequestMethod.GET)
		public ModelAndView index(){
			ModelAndView mav = new ModelAndView();	
			mav.getModelMap().addAttribute("carrito", compraRepository.findAll());
			return mav;
		}
		
		@RequestMapping(value="/detalle", method=RequestMethod.GET)
		public ModelAndView detalle(Producto producto){
			ModelAndView mav = new ModelAndView();	
			mav.getModelMap().addAttribute("producto", producto);
			return mav;
		}
		
		@RequestMapping(value="/borrar", method=RequestMethod.GET)
		public ModelAndView borrar(@RequestParam int id, @RequestParam int cantidad){
			ModelAndView mav = new ModelAndView();	
			List<ProductoComprable> lista = compraRepository.findAll();
			ProductoComprable producto = compraRepository.get(id, cantidad);
			lista.remove(producto);
			return mav;
		}
		
		@RequestMapping(value="/guardar", method=RequestMethod.GET)
		public ModelAndView guardar(@RequestParam int id, @RequestParam int cantidad){
			ModelAndView mav = new ModelAndView();	
			List<ProductoComprable> lista = compraRepository.findAll();
			ProductoComprable producto = compraRepository.get(id, cantidad);
			lista.add(compraRepository.getIndex(producto), producto);
			return mav;
		}
		
		@RequestMapping(value="/verDetalle", method=RequestMethod.POST)
		public ModelAndView verDetalle(@RequestParam int id){
			ModelAndView mav = new ModelAndView("redirect:detalle");
			Producto producto = productoRepository.get(id);
			mav.getModelMap().addAttribute(producto);
			return mav;
		}
	}
}
