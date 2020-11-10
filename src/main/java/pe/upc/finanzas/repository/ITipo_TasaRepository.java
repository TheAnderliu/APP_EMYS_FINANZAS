package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Tipo_Tasa;

@Repository
public interface ITipo_TasaRepository extends JpaRepository<Tipo_Tasa, Long> {

	List<Tipo_Tasa> findByNTipo_Tasa(String NTipo_Tasa) throws Exception;
	
}
