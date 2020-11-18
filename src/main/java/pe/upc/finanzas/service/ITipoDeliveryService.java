package pe.upc.finanzas.service;

import java.util.List;

import pe.upc.finanzas.entity.TipoDelivery;

public interface ITipoDeliveryService {

	public Integer save(TipoDelivery tipodelivery);
	
	public void update(TipoDelivery tipodelivery);
	
	public void delete(TipoDelivery tipodelivery);
	
	public TipoDelivery finByID(Long CTipoDelivery);
	
	public List<TipoDelivery> findAll();
	
}
