package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoTasa;

public interface ITipoTasaService{

	public Integer save(TipoTasa tipotasa);
	
	public void update(TipoTasa tipotasa);
	
	public void delete(TipoTasa tipotasa);
	
	public TipoTasa finByID(Long CTipoTasa);
	
	public List<TipoTasa> findAll();
	
	List<TipoTasa> findByNTipoTasa(String NTipoTasa);
}
