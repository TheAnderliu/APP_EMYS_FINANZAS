package pe.upc.finanzas.service;

import java.util.List;


import pe.upc.finanzas.entity.TipoMoneda;

public interface ITipoMonedaService{

	public Integer save(TipoMoneda tipomoneda);
	
	public void update(TipoMoneda tipomoneda);
	
	public void delete(TipoMoneda tipomoneda);
	
	public TipoMoneda findByID(Long CTipoMoneda);
	
	public List<TipoMoneda> findAll();
	
	List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda);
	
}
