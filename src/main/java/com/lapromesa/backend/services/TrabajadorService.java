package com.lapromesa.backend.services;

import com.lapromesa.backend.entity.Actividad;
import com.lapromesa.backend.entity.Trabajador;
import com.lapromesa.backend.exception.NotFoundException;
import com.lapromesa.backend.repository.ActividadRepository;
import com.lapromesa.backend.repository.TrabajadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TrabajadorService {

    /**
     * Injection of dependency
     */
    private final TrabajadorRepository trabajadorRepository;
    private final ActividadRepository actividadRepository;
    /**
     *
     * @return
     */
    public List<Trabajador> findAllTrabajador(){
        List<Trabajador> listTrabajador = new ArrayList<>();

        Optional.ofNullable(trabajadorRepository.findAll())
                .orElseThrow(()->new NotFoundException("empty list",new Exception("")))
                .forEach(listTrabajador::add);

        return listTrabajador;
    }

    /**
     *
     * @param id
     * @return
     */
    public Trabajador findById(Long id){
        return trabajadorRepository.findById(id).orElseThrow(()->new NotFoundException("the employee does not exist",new Exception()));
    }

    /**
     *
     * @param trabajador
     * @return
     */
    public Trabajador saveTrabajador (Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    /**
     *
     * @param id
     */
    public void deleteTrabajador(Long id){
        trabajadorRepository.deleteById(id);
    }


    public Actividad saveActividad (Actividad actividad){

        return actividadRepository.save(actividad);
    }


}
