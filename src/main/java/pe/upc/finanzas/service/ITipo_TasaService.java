package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.Tipo_Tasa;

public interface ITipo_TasaService extends CrudService<Tipo_Tasa, Long>{

	List<Tipo_Tasa> findByNTipo_Tasa(String NTipo_Tasa) throws Exception;
}
