package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoTasa;

public interface ITipoTasaService extends CrudService<TipoTasa, Long>{

	List<TipoTasa> findByNTipoTasa(String NTipoTasa) throws Exception;
}
