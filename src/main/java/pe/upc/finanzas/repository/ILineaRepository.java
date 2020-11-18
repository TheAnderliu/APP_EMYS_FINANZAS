package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

@Repository
public interface ILineaRepository extends JpaRepository<Linea, Long>{

	@Query("select count(e.CLinea) from Linea e where e.CLinea =:CLinea")
	public int searchCLineaLinea(@Param("CLinea")Long CLinea);
	
	@Query("select e from Linea e where e.CLinea = :CLinea")
	public Linea findByCLinea(@Param("CLinea")Long CLinea);
	
	@Query("select e from Linea e where e.DFechaEmision = :DFechaEmision")
	List<Linea> findByDFechaEmision(@Param("DFechaEmision")Date DFechaEmision);
	
	
	@Query("select e from Linea e where e.Cliente = :CCliente")
	public Linea findByCCliente(@Param("CCliente") Long CCliente);
	
	
	@Query("select count(e.CTransaccion) from Transaccion e where e.linea =:CLinea")
	public int CantidadDeTransaccionesPorLinea(@Param("CLinea")Long CLinea);
	
	
	@Query("select e.CTransaccion from Transaccion e where e.linea =:CLinea order by e.DFecha ASC")
	List<Transaccion> ListaDeTransaccionees(@Param("CLinea")Long CLinea); 
	
	
	@Query(value = "select datediff(:FechaMayor, :FechaMenor)", nativeQuery = true)
	public int DiferenciaEntreFecha(@Param("FechaMayor")Date FechaMayor, @Param("FechaMenor")Date FechaMenor);
	
}
