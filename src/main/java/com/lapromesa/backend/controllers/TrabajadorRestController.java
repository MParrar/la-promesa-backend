package com.lapromesa.backend.controllers;

import com.lapromesa.backend.entity.Actividad;
import com.lapromesa.backend.entity.Trabajador;
import com.lapromesa.backend.entity.Venta;
import com.lapromesa.backend.services.TrabajadorService;
import com.lapromesa.backend.services.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/trabajador")
public class TrabajadorRestController {
    /**
     * Injection of dependency
     */
    private final TrabajadorService trabajadorService;

    /**
     * Endpoint Get findAll
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Trabajador>> findAllTrabajadores(){
        return new ResponseEntity <> (trabajadorService.findAllTrabajador(), HttpStatus.OK);
    }


    /**
     *
     * @param id of employee that you need found
     * @return the employee that you want
     */
    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> findById(@PathVariable Long id){
        return new ResponseEntity<>(trabajadorService.findById(id), HttpStatus.OK);
    }

    /**
     *
     * @param trabajador
     * @return
     */
    @PostMapping
    public ResponseEntity<Trabajador> saveTrabajador(@Validated @RequestBody Trabajador trabajador){
        return new ResponseEntity<>(trabajadorService.saveTrabajador(trabajador),HttpStatus.CREATED);
    }

    /**
     *
     * @param trabajador
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> saveTrabajador(@Validated @RequestBody Trabajador trabajador, @PathVariable Long id){
        Trabajador trabajadorNew = trabajadorService.findById(id);
        trabajadorNew = trabajador;
        trabajadorNew.setId(id);
        return new ResponseEntity<>(trabajadorService.saveTrabajador(trabajadorNew),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteTrabajador(@PathVariable Long id){

        trabajadorService.deleteTrabajador(id);
        return new ResponseEntity<>("Employee successfully deleted",HttpStatus.OK);
    }

    /**
     *
     * @param actividad
     * @return
     */
    @PostMapping("/actividad" )
    public ResponseEntity<Actividad> saveActividad(@Validated @RequestBody Actividad actividad){
        return new ResponseEntity<>(trabajadorService.saveActividad(actividad),HttpStatus.CREATED);
    }


}
