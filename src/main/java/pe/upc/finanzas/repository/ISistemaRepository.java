package pe.upc.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Sistema;

@Repository
public interface ISistemaRepository extends JpaRepository<Sistema, Integer> {

}
