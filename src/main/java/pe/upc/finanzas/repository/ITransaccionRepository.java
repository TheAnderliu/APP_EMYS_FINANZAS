package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

	@Query("select count(e.CTransaccion) from Transaccion e where e.CTransaccion =:CTransaccion")
	public int searchCTransaccionTransaccion(@Param("CTransaccion")Long CTransaccion);
	
	@Query("select e from Transaccion e where e.CTransaccion = :CTransaccion")
	public Transaccion findByCTransaccion(@Param("CTransaccion")Long CTransaccion);
	
	
	@Query("select e from Transaccion e where e.DFecha = :DFecha")
	List<Transaccion> findByDFecha(@Param("DFecha")Date DFecha);
	
	@Query("select e from Transaccion e where e.DFecha between :DesdeFecha and :HastaFecha")
	List<Transaccion> encontrartransaccionentrefechas(@Param("DesdeFecha")Date DesdeFecha, @Param("HastaFecha")Date HastaFecha);
	
	@Query("select e from Transaccion e where e.BTipo = :BTipo")
	List<Transaccion> findByBTipo(@Param("BTipo")boolean BTipo);
	
	@Query("select e from Transaccion e where e.linea = :Linea")
	List<Transaccion> encontrarporLinea(@Param("Linea")Linea Linea) ;
	
	
	//Para actualizar la fecha de cierre
	@Query("select count(e.CTransaccion) from Transaccion e where e.linea = :Linea")
	public int cantidadDeTransaccionesDeUnaLinea(@Param("Linea")Linea Linea);
	
	@Query("select min(e.DFecha) from Transaccion e where e.linea = :Linea and e.BTipo = 1")
	public Date fechaMinimadeTransacciones(@Param("Linea")Linea Linea);
	
	@Query("select e from Transaccion e where  e.linea = :Linea and e.DFecha <= :HastaFecha")
	List<Transaccion> encontrarporLineaMenorAFecha(@Param("Linea") Linea Linea, @Param("HastaFecha") Date HastaFecha);
	
	
	@Transactional
	@Modifying
	@Query("delete from Transaccion e where e.linea = :Linea")
	void borrarTodasLasTransaccionesDeLinea(@Param("Linea") Linea Linea);
	
	
//	@Transactional
//	@Modifying
//	@Query("insert into Transaccion ")
//	void insertarMantenimiento(@Param("Dia30avoLuegoDeLaPrimeraTransaccion")Date Dia30avoLuegoDeLaPrimeraTransaccion, @Param("Linea")Linea Linea);
//	
	
}
