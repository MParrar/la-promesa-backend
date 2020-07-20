package com.lapromesa.backend.repository;

import com.lapromesa.backend.entity.Trabajador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends CrudRepository<Trabajador,Long> {
}
