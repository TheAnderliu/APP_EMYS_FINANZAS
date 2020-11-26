package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Transaccion;

@Repository
public interface ILineaRepository extends JpaRepository<Linea, Long>{

	@Query("select count(e.CLinea) from Linea e where e.CLinea =:CLinea")
	public int searchCLineaLinea(@Param("CLinea")Long CLinea);
	
	@Query("select e from Linea e where e.CLinea = :CLinea")
	public Linea findByCLineaLinea(@Param("CLinea")Long CLinea);
	
	@Query("select e from Linea e where e.DFechaEmision = :DFechaEmision")
	List<Linea> findByDFechaEmision(@Param("DFechaEmision")Date DFechaEmision);
	
	
	@Query("select e from Linea e where e.Cliente = :cliente")
	public Linea findByCliente(Cliente cliente);
	
	
	@Query("select count(e.CTransaccion) from Transaccion e where e.linea =:Linea")
	public int CantidadDeTransaccionesPorLinea(@Param("Linea")Linea Linea);
	
	
	@Query("select e from Transaccion e where e.linea =:Linea and e.DFecha <=:FechaHasta  order by e.DFecha ASC")
	List<Transaccion> ListaDeTransaccionees(@Param("Linea")Linea Linea, @Param("FechaHasta") Date FechaHasta); 
	
	
	@Query(value = "select datediff(:FechaMayor, :FechaMenor)", nativeQuery = true)
	public int DiferenciaEntreFecha(@Param("FechaMayor")Date FechaMayor, @Param("FechaMenor")Date FechaMenor);
	
}
