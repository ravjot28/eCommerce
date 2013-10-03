package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.account.Account;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountForm;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountRepository;
import web.ecommerce.tpfinal.ecommerce_web.account.FabricanteForm;
import web.ecommerce.tpfinal.ecommerce_web.account.ProductoForm;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.repository.FabricanteRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoRepository;


@Controller
@RequestMapping(value = "/administrador/**")
public class AdminController {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value = "/mainAdmin", method = RequestMethod.GET)
	public ModelAndView mainAdmin() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping(value = "/cargarFabricante", method = RequestMethod.GET)
	public ModelAndView cargarFabricante() {
		ModelAndView mav = new ModelAndView();
		//obtener lista de fabricantes
		mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
		return mav;
	}
	@RequestMapping(value = "/cargarProducto", method = RequestMethod.GET)
	public ModelAndView cargarProducto() {
		ModelAndView mav = new ModelAndView();
		//obtener lista de fabricantes
		mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
		
		//obtener lista de productos
		mav.getModelMap().addAttribute("productos", productoRepository.getAll());
		return mav;
	}
	@RequestMapping(value = "/consultarUsuario", method = RequestMethod.GET)
	public ModelAndView consultarUsuario() {
		ModelAndView mav = new ModelAndView();
		//obtener lista de usuarios
		mav.getModelMap().addAttribute("accounts", accountRepository.getAll());
		return mav;
	}
	@RequestMapping(value="/createF", method=RequestMethod.POST)
	public ModelAndView createF(@ModelAttribute FabricanteForm fabricanteForm){
		ModelAndView mav = new ModelAndView("redirect:cargarFabricante");

		Fabricante fabri = new Fabricante(fabricanteForm.getNombre());
		
		fabricanteRepository.createF(fabri);
		System.out.println("el fabricante creado tiene id = " + fabri.getId());


		return mav;
	}
	@RequestMapping(value="/createP", method=RequestMethod.POST)
	public ModelAndView createP(@RequestParam ("nombre")String nombre,@RequestParam ("idFabricante")int idFabricante,@RequestParam ("precio")int precio){
		ModelAndView mav = new ModelAndView("redirect:cargarProducto");
		
		Fabricante fab = fabricanteRepository.getF(idFabricante);
		Producto prod = new Producto(nombre,fab,precio);
		
		System.out.println("ACA ES EL ERROR");
		productoRepository.createP(prod);
		System.out.println("O NO.");
		System.out.println("el producto creado tiene id = " + prod.getId());


		return mav;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam ("id") int id, @RequestParam ("tipo") String tipo){
		ModelAndView mav = new ModelAndView("redirect:cargarProducto");
			
			if (tipo.equals("producto")){
				System.out.println(" NO SE HACE EL DELETEP");
				productoRepository.deleteP(id);
				System.out.println("SE HACE EL DELETEP");
			}else if (tipo.equals("fabricante")){
				fabricanteRepository.deleteF(id);
			}else if (tipo.equals("account")){
				accountRepository.deleteU(id);
			}

		return mav;
	}
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public ModelAndView editar(@RequestParam ("id")int id , @RequestParam ("tipo")String tipo){
		ModelAndView mav = new ModelAndView();
		
		if (tipo.equals("producto")){
			Producto producto=productoRepository.getP(id);
			mav.getModelMap().addAttribute("producto", producto);
		}else if (tipo.equals("fabricante")){
			Fabricante fabricante= fabricanteRepository.getF(id);
			mav.getModelMap().addAttribute("fabricante", fabricante);
		}else if (tipo.equals("usuario")){
			Account usuario= accountRepository.getU(id);
			mav.getModelMap().addAttribute("usuario", usuario);
		}
		return mav;
	}
	@RequestMapping(value="/editarP", method=RequestMethod.POST)
	public ModelAndView editarP(@ModelAttribute ProductoForm productoForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		Producto producto = productoRepository.getP(productoForm.getId());
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		producto.setFabricante(fabricanteRepository.getF(productoForm.getIdFabricante()));
		productoRepository.saveP(producto);
		return mav;
	}
	@RequestMapping(value="/editarU", method=RequestMethod.POST)
	public ModelAndView editarU(@ModelAttribute AccountForm accountForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		Account account = accountRepository.getU(accountForm.getId());
		account.setEmail(accountForm.getEmail());
		account.setPassword(accountForm.getPassword());
		account.setRole(accountForm.getRole());

		
		accountRepository.saveU(account);
		return mav;
	}	
	@RequestMapping(value="/editarF", method=RequestMethod.POST)
	public ModelAndView editar(@ModelAttribute FabricanteForm fabricanteForm){
		ModelAndView mav = new ModelAndView("redirect:index");
		Fabricante fabricante = fabricanteRepository.getF(fabricanteForm.getId());
		fabricante.setNombre(fabricanteForm.getNombre());
		
		fabricanteRepository.saveF(fabricante);
		return mav;
	}
}