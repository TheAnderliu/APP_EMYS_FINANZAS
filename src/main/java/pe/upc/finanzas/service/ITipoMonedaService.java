package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoMoneda;

public interface ITipoMonedaService extends CrudService<TipoMoneda, Long>{

	List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda);
	
}
