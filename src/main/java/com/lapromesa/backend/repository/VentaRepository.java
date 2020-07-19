package com.lapromesa.backend.repository;

import com.lapromesa.backend.entity.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository<Venta,Long> {
}
