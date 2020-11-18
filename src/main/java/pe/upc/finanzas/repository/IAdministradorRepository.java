package pe.upc.finanzas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Administrador;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, Long>{

	
	@Query("select count(e.CAdministrador) from Administrador e where e.CAdministrador =:CAdministrador")
	public int searchCAdministradorAdministrador(@Param("CAdministrador") Long CAdministrador);
	
	@Query("select e from Administrador e where e.CAdministrador = :CAdministrador")
	public Administrador findByCAdministrador(@Param("CAdministrador") Long CAdministrador);
	
	@Query("select e from Administrador e where e.NAdministrador = :NAdministrador")
	public Administrador findByNAdministrador(@Param("NAdministrador")String NAdministrador);
	
}
