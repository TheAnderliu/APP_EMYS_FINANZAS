package pe.upc.finanzas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.upc.finanzas.entity.Administrador;
import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.IPeriodoTasaService;
import pe.upc.finanzas.service.ITipoDeliveryService;
import pe.upc.finanzas.service.ITipoMantenimientoService;
import pe.upc.finanzas.service.ITipoMonedaService;
import pe.upc.finanzas.service.ITipoTasaService;
import pe.upc.finanzas.service.ITransaccionService;




@Controller
public class HomeController {
	
	@Autowired
	private ITipoMonedaService tipomonedaService;
	
	@Autowired
	private ITipoMantenimientoService tipomantenimientoService;
	
	@Autowired
	private ITipoTasaService tipotasaService;
	
	@Autowired
	private IPeriodoTasaService periodotasaService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ITransaccionService transaccionService;
	
	@Autowired
	private ITipoDeliveryService tipodeliveryService; 

	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
		return "dashboard";
	}
	
	@GetMapping("/clientes")
	public String MostrarClientes(Model model) {
		
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listadoClientes", clienteService.findAll());
		
		return "clientes";
	}
	
	@GetMapping("/dashboard")
	public String MostrarDashboard(Model model, HttpSession session) {
		
		return "dashboard";
	}
	
	@GetMapping("/registrarcliente")
	public String RegistrarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "registrarcliente";
	}
	
	@GetMapping("/registrarlineadecredito")
	public String RegistrarLinea(Model model) {
		
		
		
		model.addAttribute("administrador", new Administrador());	
		
		model.addAttribute("linea", new Linea());
		
		
		model.addAttribute("listadoClientes", clienteService.findAll());
		
		model.addAttribute("listadoTipomoneda", tipomonedaService.findAll());
		
		model.addAttribute("listadoTipomantenimiento", tipomantenimientoService.findAll());
		model.addAttribute("listadoTipotasa", tipotasaService.findAll());
		model.addAttribute("listadoPeriodotasa", periodotasaService.findAll());
		
	
		return "registrarlineadecredito";
	}
	
	@GetMapping("/registrartransaccion")
	public String RegistrarTransaccion(Model model, HttpSession session) {
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yy-MM-dd");
		
		Date DesdeFecha = new Date();
		
		Date HastaFecha = new Date();
		
		model.addAttribute("DesdeFecha", new SimpleDateFormat("yy-MM-dd").format(DesdeFecha));
		model.addAttribute("HastaFecha", new SimpleDateFormat("yy-MM-dd").format(HastaFecha));
		
		model.addAttribute("listadoClientes", clienteService.findAll());
		model.addAttribute("transaccion", new Transaccion());
		model.addAttribute("listadoTransacciones", transaccionService.findAll());
		model.addAttribute("listadoTipoDelivery", tipodeliveryService.findAll());
		
		return "registrartransaccion";
	}
}
