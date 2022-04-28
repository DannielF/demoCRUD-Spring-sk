package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access object for Usuario
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    /**
     * Find a usuario by priority
     * @param prioridad Integer
     */
    public abstract List<UsuarioModel> findByPrioridad(Integer prioridad);
}