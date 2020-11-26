package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.TipoDelivery;
import pe.upc.finanzas.repository.ITipoDeliveryRepository;
import pe.upc.finanzas.service.ITipoDeliveryService;

@Service
public class TipoDeliveryService implements ITipoDeliveryService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITipoDeliveryRepository tipodeliveryRepository;

	@Transactional
	@Override
	public Integer save(TipoDelivery tipodelivery) {
		int rpta = tipodeliveryRepository.searchCTipoDeliveryTipoDelivery(tipodelivery.getCTipoDelivery()); //0 si no existe el CIP
		if(rpta==0) {
			
			tipodeliveryRepository.save(tipodelivery);
			
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(TipoDelivery tipodelivery) {
		tipodeliveryRepository.save(tipodelivery);
		
	}

	@Transactional
	@Override
	public void delete(TipoDelivery tipodelivery) {
		tipodeliveryRepository.delete(tipodelivery);
		
	}

	@Override
	public TipoDelivery finByID(Long CTipoDelivery) {
		// TODO Auto-generated method stub
		return tipodeliveryRepository.findByCTipoDelivery(CTipoDelivery);
	}

	@Override
	public List<TipoDelivery> findAll() {
		// TODO Auto-generated method stub
		return tipodeliveryRepository.findAll();
	} 

	
}
