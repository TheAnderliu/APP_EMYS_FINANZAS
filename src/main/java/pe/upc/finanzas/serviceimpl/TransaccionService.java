package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;
import pe.upc.finanzas.repository.ITransaccionRepository;
import pe.upc.finanzas.service.ITransaccionService;

@Service
public class TransaccionService implements ITransaccionService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	@Transactional
	@Override
	public Transaccion save(Transaccion entity) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.save(entity);
	}

	@Transactional
	@Override
	public Transaccion update(Transaccion entity) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		transaccionRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transaccion> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transaccion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transaccion> findByDFecha(Date DFecha) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.findByDFecha(DFecha);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Transaccion> findByBTipo(boolean BTipo) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.findByBTipo(BTipo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Transaccion> findByLinea(Linea Linea) throws Exception {
		// TODO Auto-generated method stub
		return transaccionRepository.findByLinea(Linea);
	}

}
