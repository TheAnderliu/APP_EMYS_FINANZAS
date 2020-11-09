package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoMantenimiento;

public interface ITipoMantenimientoService extends CrudService<TipoMantenimiento, Integer>{

	List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento);
	
}
