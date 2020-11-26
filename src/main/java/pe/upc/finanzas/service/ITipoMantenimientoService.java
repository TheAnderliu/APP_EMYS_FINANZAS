package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoMantenimiento;

public interface ITipoMantenimientoService{

	public Integer save(TipoMantenimiento tipoMantenimiento);
	
	public void update(TipoMantenimiento tipoMantenimiento);
	
	public void delete(TipoMantenimiento tipoMantenimiento);
	
	public TipoMantenimiento findByID(Long CTipoMantenimiento);	
	
	public List<TipoMantenimiento> findAll();
	
	List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento);
	
}
