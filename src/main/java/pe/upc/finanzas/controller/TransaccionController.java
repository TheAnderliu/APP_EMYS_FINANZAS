package pe.upc.finanzas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.finanzas.entity.Transaccion;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.ITipoDeliveryService;
import pe.upc.finanzas.service.ITransaccionService;

@Controller
public class TransaccionController {

	@Autowired
	private ITransaccionService transaccionService;
	
	@Autowired
	private ITipoDeliveryService tipodeliveryService;
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/insertarTransaccion")
	public String insertarTransaccion(@Valid Transaccion transaccion, BindingResult result, Model model, SessionStatus status) {
		
		model.addAttribute("listadoTipoDelivery", tipodeliveryService.findAll());
		model.addAttribute("listadoClientes", clienteService.findAll());
		model.addAttribute("transaccion", new Transaccion());
		model.addAttribute("DesdeFecha", new Date());
		model.addAttribute("HastaFecha", new Date());
		
		if (result.hasErrors()) {
			model.addAttribute("mensaje", "Error al inicio de la funcion");
			return "registrartransaccion";
			
		} else {
			
			int rpta = transaccionService.save(transaccion);
			
			if (rpta>0) {
				
				model.addAttribute("mensaje", "Se está intentando registrar de nuevo una transaccion ya realizada (El ID se repite)");
				return "registrartransaccion";
				
			} else {
				model.addAttribute("mensaje", "¡Transacción registrada!");
				status.setComplete();
			}
			
			
			
		}
			
		
		model.addAttribute("listadoTransacciones", transaccionService.findAll());
		
		
		return "registrartransaccion";
		
		
	}
	
	
	@PostMapping("/encontrarTransaccionesEntreFechas")
	public String EncontrarTransaccionesEntreFechas(@RequestParam("DesdeFecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date DesdeFecha, @RequestParam("HastaFecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date HastaFecha,Model model) {
		
//		
//		if (result.hasErrors()) {
//			return "registrartransaccion";
//		} else {
		
		
		if (DesdeFecha==null & HastaFecha==null) {
			
			//model.addAttribute("mensajefecha", "Debe ingresar un rango de fecha");
			model.addAttribute("listadoTransacciones", transaccionService.findAll());
			
		} else {
			
//			SimpleDateFormat formatofecha = new SimpleDateFormat("yy-MM-dd");
//			
//			Date DesdeFechaCasteado = null;
//			try {
//				
//				DesdeFechaCasteado = formatofecha.parse(DesdeFecha);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			Date HastaFechaCasteado = null;
//			try {
//				HastaFechaCasteado = formatofecha.parse(HastaFecha);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			System.out.println("Fecha Desde: "+ DesdeFecha.toString());
			
			System.out.println("Fecha Hasta: "+ HastaFecha.toString());
			
			
			model.addAttribute("listadoTransacciones", transaccionService.encontrartransaccionentrefechas(DesdeFecha, HastaFecha));
			
		}
		
		model.addAttribute("DesdeFecha", new Date());
		model.addAttribute("HastaFecha", new Date());
		
		model.addAttribute("listadoClientes", clienteService.findAll());
		model.addAttribute("transaccion", new Transaccion());
		
		model.addAttribute("listadoTipoDelivery", tipodeliveryService.findAll());
		
		return "registrartransaccion";
		
		}
//	}

	

	
	
}
