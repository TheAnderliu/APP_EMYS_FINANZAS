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
	public Integer save(Transaccion transaccion) {
		// TODO Auto-generated method stub
		int rpta = transaccionRepository.searchCTransaccionTransaccion(transaccion.getCTransaccion());
		if (rpta==0) {
			transaccionRepository.save(transaccion);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.save(transaccion);
	}

	@Transactional
	@Override
	public void delete(Transaccion transaccion) {
		// TODO Auto-generated method stub
		transaccionRepository.delete(transaccion);
	}

	@Override
	public Transaccion findByID(Long CTransaccion) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByCTransaccion(CTransaccion);
	}

	@Override
	public List<Transaccion> findAll() {
		// TODO Auto-generated method stub
		return transaccionRepository.findAll();
	}

	@Override
	public List<Transaccion> findByDFecha(Date DFecha) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByDFecha(DFecha);
	}

	@Override
	public List<Transaccion> findByBTipo(boolean BTipo) {
		// TODO Auto-generated method stub
		return transaccionRepository.findByBTipo(BTipo);
	}

	@Override
	public List<Transaccion> encontrarporLinea(Long CLinea) {
		// TODO Auto-generated method stub
		return transaccionRepository.encontrarporLinea(CLinea);
	}

	@Override
	public List<Transaccion> encontrartransaccionentrefechas(Date DesdeFecha, Date HastaFecha) {
		// TODO Auto-generated method stub
		return transaccionRepository.encontrartransaccionentrefechas(DesdeFecha, HastaFecha);
	}
	
	

}
