package pe.upc.finanzas.service;

import java.util.Date;
import java.util.List;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

public interface ITransaccionService extends CrudService<Transaccion, Integer>{

	List<Transaccion> findByDFecha(Date DFecha) throws Exception;
	List<Transaccion> findByBTipo(boolean BTipo) throws Exception;
	List<Transaccion> findByLinea(Linea Linea) throws Exception;
	
}
