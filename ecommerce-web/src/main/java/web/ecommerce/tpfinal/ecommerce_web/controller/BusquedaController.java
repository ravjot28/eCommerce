package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Compra;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.repository.*;
@Controller
@RequestMapping(value="/buscar/**")
public class BusquedaController {

	@Autowired
	private ProductoRepository ProductoRepository;
	
	//@Autowired
	//private CompraRepository compraRepository;
	
	@RequestMapping(value="/busqueda", method=RequestMethod.POST)
	public ModelAndView busqueda(@RequestParam String nombre, @RequestParam int minimo, @RequestParam int maximo){
		ModelAndView mav;

		//Esto hace la comparacion para la busqueda de productos por marca y precio max/min
		if (nombre != null || minimo != 0 || maximo != 0){
			mav = new ModelAndView("redirect:resultado");
			ArrayList<Producto> productos = new ArrayList<Producto>();
			for (Producto prod : ProductoRepository.findAll()){
				if (prod.getFabricante().getNombre().equals(nombre) || nombre.equals(null)){
					if (prod.getPrecio() < maximo || (maximo == 0)){
						if (prod.getPrecio() > minimo){
							productos.add(prod);
							
						}
					}
				}
			}
			mav.getModelMap().addAttribute("producto", productos);
		}
		else {
			mav = new ModelAndView("redirect:buscar");
			mav.getModelMap().addAttribute("mensaje", "Ingrese el/los parámetro/s para la búsqueda");
		}
		return mav;
	}
	
	//Avisar que se tiene que pasar a false el estado de Compra
	/*@RequestMapping(value="/agregarAlCarrito", method=RequestMethod.POST)
	public ModelAndView agregarAlCarrito(@RequestParam int idProducto){
		Compra compra = null;
		ModelAndView mav = new ModelAndView();
		Producto producto = ProductoRepository.get(idProducto);
		ProductoComprable productoComprable = new ProductoComprable(producto, producto.getPrecio(), 1);
		if(compraRepository.getEstado() == false){
			compraRepository.create(compra);
			compraRepository.agregarALista(productoComprable);
		}else{
			compraRepository.agregarALista(productoComprable);
		}
		return mav;
	}*/
	
	
	@RequestMapping(value="/volver", method=RequestMethod.POST)
	public ModelAndView volver(){
		ModelAndView mav = new ModelAndView("redirect:/commerce/carrito");
		return mav;
	}
}*/
