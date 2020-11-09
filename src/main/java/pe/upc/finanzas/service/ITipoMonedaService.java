package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoMoneda;

public interface ITipoMonedaService extends CrudService<TipoMoneda, Integer>{

	List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda);
	
}
