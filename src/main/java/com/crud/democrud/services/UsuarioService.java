package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Services for Usuario
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Get all usuario
     * @return List of usuario
     */
    @Transactional(readOnly = true)
    public List<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Save an usuario
     * @param usuario Object
     * @return Usuario
     */
    @Transactional
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Gets an usuario by id
     * @param id Long
     * @return Usuario
     */
    @Transactional(readOnly = true)
    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Updates an usuario
     * @param id Long
     * @param usuario Object
     * @return Usuario
     */
    @Transactional
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    /**
     * Gets an usuario by priority
     * @param prioridad Integer
     * @return Usuario
     */
    @Transactional(readOnly = true)
    public List<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    /**
     * Deletes an usuario
     * @param id Long
     * @return Boolean
     */
    @Transactional
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }


}