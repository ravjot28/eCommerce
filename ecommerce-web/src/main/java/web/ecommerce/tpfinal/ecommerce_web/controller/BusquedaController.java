package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.security.Principal;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.account.AccountRepository;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.repository.*;

@Controller
@RequestMapping(value="/buscar/**")
@SessionAttributes("carrito")
public class BusquedaController {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private BusquedaRepository busquedaRepository;	
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ProductoComprableRepository productoComprableRepository;
	
	@RequestMapping(value="/busqueda", method=RequestMethod.GET)
	public ModelAndView busqueda(String mensaje2){
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("mensaje2", mensaje2);
		return mav;
	}
	@RequestMapping(value="/resultados", method=RequestMethod.POST)
	public ModelAndView resultados(@RequestParam String nombre, @RequestParam float minimo, @RequestParam float maximo){
		ModelAndView mav;
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		if (nombre != null || minimo != 0 || maximo != 0){
			mav = new ModelAndView();
			productos.addAll(busquedaRepository.armarLista(nombre, minimo, maximo));
			mav.getModelMap().addAttribute("productos", productos);
		}else{
			mav = new ModelAndView("redirect:/busqueda");
			mav.getModelMap().addAttribute("mensaje", "Ingrese el/los parámetro/s para la búsqueda");
		}
		return mav;
		}
	/*@RequestMapping(value="/resultados", method=RequestMethod.POST)
	public ModelAndView resultados(@RequestParam String nombre, @RequestParam int minimo, @RequestParam int maximo){
		ModelAndView mav;
		//Esto hace la comparacion para la busqueda de productos por marca y precio max/min
		if (nombre != null || minimo != 0 || maximo != 0){
			mav = new ModelAndView();
			//Fabricante fabricante = BusquedaRepository.getByNombre(nombre);
			ArrayList<Producto> productos = new ArrayList<Producto>();
			for (Producto prod : ProductoRepository.findAll()){
				if (prod.getFabricante().getNombre().equals(nombre) || nombre.equals(null)){
					if (prod.getPrecio() < maximo || (maximo == 0)){
						if (prod.getPrecio() > minimo){
							System.out.println(prod.getNombre());
							productos.add(prod);
							
							
						}
					}
				}
			}
			mav.getModelMap().addAttribute("productos", productos);
		}
		else {
			mav = new ModelAndView("redirect:buscar");
			mav.getModelMap().addAttribute("mensaje", "Ingrese el/los parámetro/s para la búsqueda");
		}
		return mav;
	}*/
			
	
	@RequestMapping(value="/agregarAlCarrito", method=RequestMethod.POST)
	public ModelAndView agregarAlCarrito(@RequestParam long idProducto, Principal principal, 
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirect:busqueda");
		Producto producto = productoRepository.getP(idProducto);
		ProductoComprable productoComprable= productoComprableRepository.generar(producto, 1);
		productoComprableRepository.create(productoComprable);
		@SuppressWarnings("unchecked")
		ArrayList<ProductoComprable> carrito = (ArrayList<ProductoComprable>) request.getSession().getAttribute("carrito");
		if(carrito == null) carrito = new ArrayList<ProductoComprable>();
		carrito.add(productoComprable);
		request.getSession().setAttribute("carrito", carrito);
		return mav;
	}
}
