package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolService {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Transactional(readOnly = true)
    public List<UsuarioRol> getUserRols() {
        return (List<UsuarioRol>) usuarioRolRepository.findAll();
    }

    @Transactional
    public UsuarioRol saveUserRol(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Transactional(readOnly = true)
    public List<UsuarioRol> findByRol(String rol) {
        return usuarioRolRepository.findByRol(rol);
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioRol> findById(Long id) {
        return usuarioRolRepository.findById(id);
    }

    @Transactional
    public UsuarioRol updateUserRol(Long id, UsuarioRol usuarioRol) {
        usuarioRol.setId(id);
        return usuarioRolRepository.save(usuarioRol);
    }

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
