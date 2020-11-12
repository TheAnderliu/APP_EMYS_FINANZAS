package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Tipo_Delivery;
import pe.upc.finanzas.repository.ITipo_DeliveryRepository;
import pe.upc.finanzas.service.ITipo_DeliveryService;

@Service
public class Tipo_DeliveryService implements ITipo_DeliveryService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITipo_DeliveryRepository tipo_deliveryRepository; 

	@Transactional
	@Override
	public Tipo_Delivery save(Tipo_Delivery entity) throws Exception {
		// TODO Auto-generated method stub
		return tipo_deliveryRepository.save(entity);
	}

	@Transactional
	@Override
	public Tipo_Delivery update(Tipo_Delivery entity) throws Exception {
		// TODO Auto-generated method stub
		return tipo_deliveryRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		tipo_deliveryRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tipo_Delivery> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tipo_deliveryRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tipo_Delivery> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipo_deliveryRepository.findAll();
	}

}
