package parcial.web.martin.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import parcial.web.martin.DTOs.EntidadDTO;
import parcial.web.martin.entities.Entidad;
import parcial.web.martin.repositories.EntidadRepository;

public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    // convertir entidad a DTO
    private EntidadDTO convertirEntidadDTO(Entidad entidad) {
        return new EntidadDTO(
                entidad.getId(),
                entidad.getNit(),
                entidad.getNombre(),
                entidad.getContratos()
        );
    }

    // obtener todos las entidades
    public List<EntidadDTO> obtenerTodos() {
        List<Entidad> entidades = entidadRepository.findAll();
        System.out.println("Entidades obtenidas: " + entidades.size());
        return entidades.stream()
                        .map(this::convertirEntidadDTO)
                        .collect(Collectors.toList());
    }

    // obtener por ID
    public EntidadDTO obtenerPorId(Long id) {
        Optional<Entidad> entidad = entidadRepository.findById(id);
        return entidad.map(this::convertirEntidadDTO).orElse(null);
    }

    // crear entidad
    public EntidadDTO crearEntidad(Entidad entidad) {
        Entidad nuevaEntidad = entidadRepository.save(entidad);
        return convertirEntidadDTO(nuevaEntidad);
    }

    // actualizar entidad
    public EntidadDTO actualizarEntidad(Long id, Entidad entidadActualizada) {
        Optional<Entidad> entidadExistente = entidadRepository.findById(id);

        if (entidadExistente.isPresent()) {
            Entidad entidad = entidadExistente.get();
            entidad.setNit(entidadActualizada.getNit());
            entidad.setNombre(entidadActualizada.getNombre());
            entidad.setContratos(entidadActualizada.getContratos());

            entidadRepository.save(entidad);
            return convertirEntidadDTO(entidad);
        }
        return null;
    }

    // eliminar entidad
    public boolean eliminarEntidad(Long id){
        Optional<Entidad> entidad = entidadRepository.findById(id);
        if(entidad.isPresent()){
            entidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
