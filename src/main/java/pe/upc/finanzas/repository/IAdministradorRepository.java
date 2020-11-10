package pe.upc.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Administrador;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, Long>{

	Optional<Administrador> findByNAdministrador(String NAdministrador) throws Exception;
}
