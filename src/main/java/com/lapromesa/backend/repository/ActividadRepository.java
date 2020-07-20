package com.lapromesa.backend.repository;

import com.lapromesa.backend.entity.Actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad,Long> {
}
