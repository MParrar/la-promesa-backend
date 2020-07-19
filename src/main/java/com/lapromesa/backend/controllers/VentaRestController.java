package com.lapromesa.backend.controllers;

import com.lapromesa.backend.entity.Venta;
import com.lapromesa.backend.services.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/venta")
public class VentaRestController {
    /**
     * Injection of dependency
     */
    private final VentaService ventaService;

    /**
     * Endpoint Get findAll
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Venta>> findAllVentas(){
        return new ResponseEntity <> (ventaService.findAllVenta(), HttpStatus.OK);
    }


    /**
     *
     * @param id of sale that you need found
     * @return the sale that you want
     */
    @GetMapping("/{id}")
    public ResponseEntity<Venta> findById(@PathVariable Long id){
        return new ResponseEntity<>(ventaService.findById(id), HttpStatus.OK);
    }

    /**
     *
     * @param venta
     * @return
     */
    @PostMapping
    public ResponseEntity<Venta> saveVenta(@Validated @RequestBody Venta venta){
        return new ResponseEntity<>(ventaService.saveVenta(venta),HttpStatus.CREATED);
    }

    /**
     *
     * @param venta
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Venta> saveVenta(@Validated @RequestBody Venta venta, @PathVariable Long id){
        Venta ventaNew = ventaService.findById(id);
        ventaNew = venta;
        ventaNew.setId(id);
        return new ResponseEntity<>(ventaService.saveVenta(ventaNew),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteVenta(@PathVariable Long id){

        ventaService.deleteVenta(id);
        return new ResponseEntity<>("Sale successfully deleted",HttpStatus.OK);
    }




}
