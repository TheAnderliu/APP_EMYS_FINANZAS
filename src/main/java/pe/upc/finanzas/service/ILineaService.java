package pe.upc.finanzas.service;

import java.util.Date;
import java.util.List;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;

public interface ILineaService  extends CrudService<Linea, Long>{

	List<Linea> findByDFechaEmision(Date DFechaEmision) throws Exception;
	
	public Integer insert(Linea linea, Cliente cliente) throws Exception;
}
