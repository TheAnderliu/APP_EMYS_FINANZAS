package pe.upc.finanzas.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.ILineaService;
import pe.upc.finanzas.service.ITransaccionService;


@Controller
public class SistemaController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ILineaService lineaService;
	
	@Autowired
	private ITransaccionService transaccionService;
	
	
	
	@PostMapping("/encontrarClientesDeudoresActuales")
	public String encontrarClientesDeudoresActuales(@RequestParam("FechaActual") @DateTimeFormat(pattern = "yyyy-MM-dd") Date FechaActual,Model model){
		
		
		if (FechaActual == null) {
			model.addAttribute("mensaje", "Se debe elegir la fecha actual antes de continuar");
		} else {
			
			if (clienteService.encontrarClientesDeudores(FechaActual).isEmpty()) {
				model.addAttribute("mensaje", "No se encontraron clientes deduores en la fecha actual");
			}else {
			
			model.addAttribute("listadoClientesDeudores", clienteService.encontrarClientesDeudores(FechaActual));
			}
			
			
			transaccionService.insertarMantenimiento(FechaActual);
			
			
			
		}
		
		
		
		
		model.addAttribute("cantidadClientes", clienteService.cantidadClientes());
		
		model.addAttribute("cantidadClientesDeudores", clienteService.cantidadClientesDeudores());
		
		model.addAttribute("cliente", new Cliente());
		
		return "dashboard";
	}
	
	
	
	
	
	
	@PostMapping("/cancelarDeuda")
	public String cancelarDeuda(Cliente cliente, Model model) {
		
		Linea lineaencontrada=lineaService.encontrarLineaDeCliente(cliente);
		
		lineaService.cancelarDeuda(lineaencontrada);
		
		
		
		
		model.addAttribute("cantidadClientes", clienteService.cantidadClientes());
		model.addAttribute("cantidadClientesDeudores", clienteService.cantidadClientesDeudores());
		
		model.addAttribute("cliente", new Cliente());
		return "dashboard";
		
		
		
		
	}
	
	
	
	
	
	
	
}
