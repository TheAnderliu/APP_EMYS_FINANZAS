package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.TipoDelivery;
import pe.upc.finanzas.entity.Transaccion;
import pe.upc.finanzas.repository.ILineaRepository;
import pe.upc.finanzas.repository.ITipoDeliveryRepository;
import pe.upc.finanzas.repository.ITransaccionRepository;
import pe.upc.finanzas.service.ILineaService;
import pe.upc.finanzas.service.ITransaccionService;

@Service
public class TransaccionService implements ITransaccionService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	@Autowired
	private ILineaRepository lineaRepository;
	
	@Autowired
	private ILineaService lineaService;
	
	@Autowired
	private ITipoDeliveryRepository tipodeliveryRepository; 
	

	@Transactional
	@Override
	public Integer save(Transaccion transaccion) {
		// TODO Auto-generated method stub
		int rpta = transaccionRepository.searchCTransaccionTransaccion(transaccion.getCTransaccion());
		
		if (rpta==0) {
			
			//Se obtiene el monto del delivery
			float montoDelivery = transaccion.getTipoDelivery().getMontoTipoDelivery();
			
			//Sele suma al valor de la transaccion actual
			transaccion.setMonto(transaccion.getMonto()+montoDelivery);
			
			//Se guarda la transaccion
			transaccionRepository.save(transaccion);
			
			int cantidadDeTransaccionesDeLaLinea = transaccionRepository.cantidadDeTransaccionesDeUnaLinea(transaccion.getLinea());
			
			//Si existen transacciones de tipo deuda, se obtiene la fecha de la menor de ellas para luego sumarle 31 dias y guardar el valor de la Fecha de Cierre 
			if (cantidadDeTransaccionesDeLaLinea>0 && transaccion.isBTipo()==true) {
				
				//Extrae la linea de la transaccion para luego ser actualizada
				Linea lineaencontrada = transaccion.getLinea() ;
				
				
				//Halla la fecha minima de todas las transacciones de la linea
				Date FechaMinima = transaccionRepository.fechaMinimadeTransacciones(transaccion.getLinea());
				
				//Suma de 30 días a la fecha de la primera transacciónn
				GregorianCalendar FechaDeCierre = new GregorianCalendar();
				
				FechaDeCierre.setTime(FechaMinima);
				
				FechaDeCierre.add(Calendar.DATE, 31);
				
				
				
				//Guarda el valor de la Fecha de Cierre
				lineaencontrada.setDFechaCierre(FechaDeCierre.getTime());
				
				
				//Suma de 7 días a la fecha de cierre
				
				GregorianCalendar UltimoDiaDePago = new GregorianCalendar();
				
				UltimoDiaDePago.setTime(FechaDeCierre.getTime());
				
				UltimoDiaDePago.add(Calendar.DATE, 7);
				
				//Guarda el valor del último día de pago
				lineaencontrada.setDUltimoDiaDePago(UltimoDiaDePago.getTime());
				
				lineaRepository.save(lineaencontrada);
				
				
				
			
				
				
				//Invalidar la transacciones de deuda si se desea realizar en el periodo de pago
			
				
				
				
				
			}
			
			
			//Extrae la linea de la transaccion para luego ser actualizada
			Linea lineaencontrada = transaccion.getLinea() ;
			
			GregorianCalendar Dia30avoLuegoDeLaPrimeraTransaccion = new GregorianCalendar();
			
			Dia30avoLuegoDeLaPrimeraTransaccion.setTime(lineaencontrada.getDFechaCierre());
			
			Dia30avoLuegoDeLaPrimeraTransaccion.add(Calendar.DATE, -1);
			
			
			
			//Se comprueba si sobrepasa el limite con esta transaccion
			
			float mtotal = (lineaService.Resultados(lineaencontrada.getCliente(), transaccion.getDFecha())).getDeudaTotal();
			
			float Limite = lineaencontrada.getNumCredito();
			
			if (mtotal>=Limite || transaccion.getDFecha().after(Dia30avoLuegoDeLaPrimeraTransaccion.getTime())) {
				
				rpta = -1;
				
				transaccionRepository.delete(transaccion);
				
				
			} 
			else {
				
				rpta=0;
			}
			
			//System.out.println("Cantidad de transacciones en la linea actual: "+ cantidadDeTransaccionesDeLaLinea);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.save(transaccion);
	}

	@Transactional
	@Override
	public void delete(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.delete(transaccion);
	}

	@Override
	public Transaccion findByID(Long CTransaccion) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByCTransaccion(CTransaccion);
	}

	@Override
	public List<Transaccion> findAll() {
		// TODO Auto-generated method stub
		return transaccionRepository.findAll();
	}

	@Override
	public List<Transaccion> findByDFecha(Date DFecha) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByDFecha(DFecha);
	}

	@Override
	public List<Transaccion> findByBTipo(boolean BTipo) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByBTipo(BTipo);
	}

	@Override
	public List<Transaccion> encontrarporLinea(Linea Linea) {
		// TODO Auto-generated method stub
		return transaccionRepository.encontrarporLinea(Linea);
	}

	@Override
	public List<Transaccion> encontrartransaccionentrefechas(Date DesdeFecha, Date HastaFecha) {
		// TODO Auto-generated method stub
		return transaccionRepository.encontrartransaccionentrefechas(DesdeFecha, HastaFecha);
	}

	@Override
	public List<Transaccion> encontrarporLineaMenorAFecha(Linea lineaencontrada, Date HastaFecha) {
		// TODO Auto-generated method stub
		return transaccionRepository.encontrarporLineaMenorAFecha(lineaencontrada, HastaFecha);
	}

	@Override
	public void insertarMantenimiento(Date FechaActual) {
		
		
		
		
		List<Linea> listadoLineas = lineaService.findAll();
		
		for (Linea linea : listadoLineas) {
			
			
			GregorianCalendar Dia30avoLuegoDeLaPrimeraTransaccion = new GregorianCalendar();
			
			Dia30avoLuegoDeLaPrimeraTransaccion.setTime(linea.getDFechaCierre());
			
			Dia30avoLuegoDeLaPrimeraTransaccion.add(Calendar.DATE, -1);
			
			if (linea.getTipoMantenimiento().getNTipoMantenimiento().equals("Mensual")) {
				
			
			
			
			
				if (FechaActual.equals(Dia30avoLuegoDeLaPrimeraTransaccion.getTime())) {
					
					
					
					
					
					Transaccion transaccioMantenimmiento = new Transaccion();
					transaccioMantenimmiento.setLinea(linea);
					transaccioMantenimmiento.setTDescripcion("Cobro por Mantenimiento de cuenta mensual");
					transaccioMantenimmiento.setDFecha(FechaActual);
					transaccioMantenimmiento.setMonto(linea.getNumMantenimiento());
					transaccioMantenimmiento.setBTipo(true);
					transaccioMantenimmiento.setTipoDelivery(tipodeliveryRepository.encontrarTipoDeñiveryGratis());
					
					
					transaccionRepository.save(transaccioMantenimmiento);
					
	//			transaccionRepository.insertarMantenimiento(Dia30avoLuegoDeLaPrimeraTransaccion.getTime(), linea);
				
				
				}
				
				
				
			
			
			} else if(linea.getTipoMantenimiento().getNTipoMantenimiento().equals("Trimestral")) {
				
				
				Dia30avoLuegoDeLaPrimeraTransaccion.add(Calendar.DATE, 90);
				
				if (FechaActual.equals(Dia30avoLuegoDeLaPrimeraTransaccion.getTime())) {
					
					
					
					
					
					Transaccion transaccioMantenimmiento = new Transaccion();
					transaccioMantenimmiento.setLinea(linea);
					transaccioMantenimmiento.setTDescripcion("Cobro por Mantenimiento de cuenta Trimestral");
					transaccioMantenimmiento.setDFecha(FechaActual);
					transaccioMantenimmiento.setMonto(linea.getNumMantenimiento());
					transaccioMantenimmiento.setBTipo(true);
					transaccioMantenimmiento.setTipoDelivery(tipodeliveryRepository.encontrarTipoDeñiveryGratis());
					
					
					transaccionRepository.save(transaccioMantenimmiento);
					
	//			transaccionRepository.insertarMantenimiento(Dia30avoLuegoDeLaPrimeraTransaccion.getTime(), linea);
				
				
				}
				
				
				
				
				
				
				
				
			} else if(linea.getTipoMantenimiento().getNTipoMantenimiento().equals("Semestral")) {
				
				
				Dia30avoLuegoDeLaPrimeraTransaccion.add(Calendar.DATE, 180);
				
				if (FechaActual.equals(Dia30avoLuegoDeLaPrimeraTransaccion.getTime())) {
					
										
					
					Transaccion transaccioMantenimmiento = new Transaccion();
					transaccioMantenimmiento.setLinea(linea);
					transaccioMantenimmiento.setTDescripcion("Cobro por Mantenimiento de cuenta Semestral");
					transaccioMantenimmiento.setDFecha(FechaActual);
					transaccioMantenimmiento.setMonto(linea.getNumMantenimiento());
					transaccioMantenimmiento.setBTipo(true);
					transaccioMantenimmiento.setTipoDelivery(tipodeliveryRepository.encontrarTipoDeñiveryGratis());
					
					
					transaccionRepository.save(transaccioMantenimmiento);
					
	//			transaccionRepository.insertarMantenimiento(Dia30avoLuegoDeLaPrimeraTransaccion.getTime(), linea);
				
				
				}
				
				
				
				
			}
		
			
			
			
			
		}
		
		
		
		
		
	}
	
	

}
