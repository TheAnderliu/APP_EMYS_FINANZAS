package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


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
	
	@Query("select e from Transaccion e where e.linea = :CLinea")
	List<Transaccion> encontrarporLinea(@Param("CLinea")Long CLinea) ;
}
