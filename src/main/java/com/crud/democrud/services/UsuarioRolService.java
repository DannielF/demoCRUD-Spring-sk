package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Services for UsuarioRol
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class UsuarioRolService {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    /**
     * Get all contacts
     * @return List of contacts
     */
    @Transactional(readOnly = true)
    public List<UsuarioRol> getUserRols() {
        return (List<UsuarioRol>) usuarioRolRepository.findAll();
    }

    /**
     * Save an usuarioRol
     * @param usuarioRol Object
     * @return UsuarioRol
     */
    @Transactional
    public UsuarioRol saveUserRol(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    /**
     * Gets an usuarioRol by rol
     * @param rol String
     * @return Usuario
     */
    @Transactional(readOnly = true)
    public Optional<UsuarioRol> findByRol(String rol) {
        return usuarioRolRepository.findByRol(rol);
    }

    /**
     * Gets an usuarioRol by id
     * @param id Long
     * @return UsuarioRol
     */
    @Transactional(readOnly = true)
    public Optional<UsuarioRol> findById(Long id) {
        return usuarioRolRepository.findById(id);
    }

    /**
     * Updates an usuarioRol
     * @param id Long
     * @param usuarioRol Object
     * @return UsuarioRol
     */
    @Transactional
    public UsuarioRol updateUserRol(Long id, UsuarioRol usuarioRol) {
        usuarioRol.setId(id);
        return usuarioRolRepository.save(usuarioRol);
    }

    /**
     * Deletes an usuarioRol
     * @param id Long
     * @return Boolean
     */
    @Transactional
    public Boolean deleteUserRol(Long id) {
        try {
            usuarioRolRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
