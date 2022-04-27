package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Long> {

    public abstract List<UsuarioRol> findByRol(String rol);
}
