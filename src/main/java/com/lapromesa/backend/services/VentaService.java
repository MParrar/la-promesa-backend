package com.lapromesa.backend.services;

import com.lapromesa.backend.entity.Venta;
import com.lapromesa.backend.exception.NotFoundException;
import com.lapromesa.backend.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VentaService {

    /**
     * Injection of dependency
     */
    private final VentaRepository ventaRepository;

    /**
     *
     * @return
     */
    public List<Venta> findAllVenta(){
        List<Venta> listVentas = new ArrayList<>();

        Optional.ofNullable(ventaRepository.findAll())
                .orElseThrow(()->new NotFoundException("empty list",new Exception("")))
                .forEach(listVentas::add);

        return listVentas;
    }

    /**
     *
     * @param id
     * @return
     */
    public Venta findById(Long id){
        return ventaRepository.findById(id).orElseThrow(()->new NotFoundException("the sale does not exist",new Exception()));
    }

    /**
     *
     * @param venta
     * @return
     */
    public Venta saveVenta (Venta venta){
        return ventaRepository.save(venta);
    }

    /**
     *
     * @param id
     */
    public void deleteVenta(Long id){
        ventaRepository.deleteById(id);
    }



}
