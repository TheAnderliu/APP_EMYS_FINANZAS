package pe.upc.finanzas.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Sistema;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.ILineaService;
import pe.upc.finanzas.service.ITransaccionService;

@Controller
public class LineaController {

	@Autowired
	private ILineaService lineaService;
	
	@Autowired
	private IClienteService clienteService;

	@Autowired
 	private ITransaccionService transaccionService;
 	
	
	
	
	@PostMapping("/insertarLinea")
	public String insertarLinea(@Valid Linea linea, BindingResult result, Model model, SessionStatus status) {
		
		
		/*
		Date fechaconvertida=(Date)linea.getDFechaEmision();
		linea.setDFechaEmision(fechaconvertida);*/
		
		if (result.hasErrors()) {
			model.addAttribute("mensaje", "Error al inicio de la funcion");
			return "registrarlineadecredito";
			
		} else {
			
			 
			int rpta = lineaService.save(linea);
			if (rpta>0) {
				model.addAttribute("mensaje", "Ya existe una linea con el mismo ID");
				return "registrarlineadecredito";
			} else {
				model.addAttribute("mensaje", "¡Linea registrada!");
				status.setComplete();
				
				
			}
			
		}
		
		
		
		return "registrarlineadecredito";
	}
	
	
	@PostMapping("/clienteseleccionado")
	public String verDetalleLinea(Cliente cliente, Model model,  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date HastaFecha, BindingResult result) {
		
		//model.addAttribute("HastaFecha", new Date());
		
		
		Linea lineaencontrada=lineaService.encontrarLineaDeCliente(cliente);
		
			
		model.addAttribute("resultadosistema", lineaService.Resultados(cliente, HastaFecha));
		
		if (HastaFecha==null) {
			//Encontrar y enviar a la apagina todas las rtansacciones de una linea
			model.addAttribute("listadoTransaccionesDeCliente", transaccionService.encontrarporLinea(lineaencontrada));
			System.out.println("No se pudo extraer la linea");
			
		} else {
			
			model.addAttribute("listadoTransaccionesDeCliente", transaccionService.encontrarporLineaMenorAFecha(lineaencontrada, HastaFecha));
			System.out.println("Se extrajo la linea");
		}	
			
		//model.addAttribute("HastaFecha", new Date());
		
		model.addAttribute("cliente", cliente);
		
//		Date HastaFechaAPasar =  HastaFecha;
//		
//		model.addAttribute("fechacalculada", HastaFechaAPasar);
		
		model.addAttribute("lineadecliente", lineaService.encontrarLineaDeCliente(cliente));
		
		
		
		
		return "clienteseleccionado";
		
		
		
	}
	
	
	
	@PostMapping("/verLinea")
	public String verLinea(Cliente cliente, Model model) {
		
		model.addAttribute("linea", lineaService.encontrarLineaDeCliente(cliente));
		
		
		return "lineadecredito";
		
		
		
		
	}
	
	
	
	
}
