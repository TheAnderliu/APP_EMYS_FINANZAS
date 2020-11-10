package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

	List<Transaccion> findByDFecha(Date DFecha) throws Exception;
	List<Transaccion> findByBTipo(boolean BTipo) throws Exception;
	List<Transaccion> findByLinea(Linea Linea) throws Exception;
}
