package pe.upc.finanzas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.service.IPeriodo_TasaService;
import pe.upc.finanzas.service.ITipoMantenimientoService;
import pe.upc.finanzas.service.ITipoMonedaService;
import pe.upc.finanzas.service.ITipoTasaService;




@Controller
public class HomeController {
	
	@Autowired
	private ITipoMonedaService tipomonedaService;
	
	@Autowired
	private ITipoMantenimientoService tipomantenimientoService;
	
	@Autowired
	private ITipoTasaService tipotasaService;
	
	@Autowired
	private IPeriodo_TasaService periodotasaService;

	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
		return "dashboard";
	}
	
	@GetMapping("/clientes")
	public String MostrarClientes(Model model, HttpSession session) {
		
		return "clientes";
	}
	
	@GetMapping("/dashboard")
	public String MostrarDashboard(Model model, HttpSession session) {
		
		return "dashboard";
	}
	
	@GetMapping("/registrarlineadecredito")
	public String RegistrarLinea(Model model, HttpSession session) throws Exception {
		
			
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("linea", new Linea());
		model.addAttribute("lista_tipomoneda", tipomonedaService.findAll());
		model.addAttribute("lista_tipomantenimiento", tipomantenimientoService.findAll());
		model.addAttribute("lista_tipotasa", tipotasaService.findAll());
		model.addAttribute("lista_periodotasa", periodotasaService.findAll());
		
	
		return "registrarlineadecredito";
	}
	
	@GetMapping("/registrartransaccion")
	public String RegistrarTransaccion(Model model, HttpSession session) {
		
		return "registrartransaccion";
	}
}
