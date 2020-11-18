package pe.upc.finanzas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("select count(e.CCliente) from Cliente e where e.CCliente =:CCliente")
	public int searchCClienteCliente(@Param("CCliente")Long CCliente);
	
	@Query("select e from Cliente e where e.CCliente = :CCliente")
	public Cliente findByCCliente(@Param("CCliente")Long CCliente);
	
	@Query("select e from Cliente e where e.numTelefono = :numTelefono")
	public Cliente findByNumTelefono(@Param("numTelefono")int numTelefono);
	
	@Query("select count(e.numDNI) from Cliente e where e.numDNI =:numDNI")
	public int searchNumDNICliente(@Param("numDNI")String numDNI);
	
	@Query("select e from Cliente e where e.numDNI = :numDNI")
	public Cliente findByNumDNI(@Param("numDNI")String numDNI);
}
