package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.PeriodoTasa;

public interface IPeriodoTasaService {

	public Integer save(PeriodoTasa periodotasa);
	
	public void update(PeriodoTasa periodotasa);
	
	public void delete(PeriodoTasa periodotasa);
	
	public PeriodoTasa findByID(Long CPeriodoTasa);
	
	public List<PeriodoTasa> findAll();
	
}
