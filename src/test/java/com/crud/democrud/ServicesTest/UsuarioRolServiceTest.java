package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRolServiceTest {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Test
    public void testSaveUserRol() {
        UsuarioModel usuarioModel = new UsuarioModel("Jhon","jhon@mail.com",100);
        UsuarioRol usuarioRol = new UsuarioRol("Actor", usuarioModel);
        UsuarioRol usuarioRolRegistered = usuarioRolRepository.save(usuarioRol);
        assertNotNull(usuarioRolRegistered);
    }

    @Test
    public void testGetAllUserRoll() {
        List<UsuarioRol> usuarioRolList = (List<UsuarioRol>) usuarioRolRepository.findAll();
        assertThat(usuarioRolList).size().isGreaterThan(0);
    }

    @Test
    public void testFinByRol() {
        String rol = "Hero";
        Optional<UsuarioRol> usuarioRolFound = usuarioRolRepository.findByRol(rol);
        assertThat(usuarioRolFound.get().getRol()).isEqualTo(rol);
    }

}
