package pe.upc.finanzas.service;

import java.util.Date;
import java.util.List;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Sistema;

public interface ILineaService{

	public Integer save(Linea linea);
	
	public void update(Linea linea);
	
	public void delete(Linea linea);
	
	public Linea findByID(Long CLinea);
	
	public List<Linea> findAll();
	
	List<Linea> findByDFechaEmision(Date DFechaEmision);
	
	public Sistema Resultados(Cliente cliente, Date FechaHasta);
	
	public Linea encontrarLineaDeCliente(Cliente cliente);
	
	public void cancelarDeuda (Linea lineaencontrada);
}
