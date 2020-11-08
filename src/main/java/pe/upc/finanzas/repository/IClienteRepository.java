package pe.upc.finanzas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findByNumTelefono(int NumTelefono) throws Exception;
	Optional<Cliente> findByNumDNI(String NumDNI) throws Exception;
}
