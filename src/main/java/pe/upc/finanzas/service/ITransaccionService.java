package pe.upc.finanzas.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

public interface ITransaccionService{

	public Integer save(Transaccion transaccion);
	
	public void update(Transaccion transaccion);
	
	public void delete(Transaccion transaccion);
	
	public Transaccion findByID(Long CTransaccion);
	
	public List<Transaccion> findAll();
	
	List<Transaccion> findByDFecha(Date DFecha);

	List<Transaccion> findByBTipo(boolean BTipo);
	
	List<Transaccion> encontrarporLinea(Long CLinea);
	
	List<Transaccion> encontrartransaccionentrefechas(Date DesdeFecha, Date HastaFecha);
	
}
