package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Data access object for UsuarioRol
 *
 * @version 1.0.0
 * @author Daniel Granados
 * @since 1.0.0
 */
@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Long> {

    /**
     * Find a usuarioRol by rol
     * @param rol String
     */
    public abstract Optional<UsuarioRol> findByRol(String rol);
}
