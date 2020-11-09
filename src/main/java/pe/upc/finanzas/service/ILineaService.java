package pe.upc.finanzas.service;

import java.util.Date;
import java.util.List;

import pe.upc.finanzas.entity.Linea;

public interface ILineaService  extends CrudService<Linea, Integer>{

	List<Linea> findByDFechaEmision(Date DFechaEmision) throws Exception;
	
}
