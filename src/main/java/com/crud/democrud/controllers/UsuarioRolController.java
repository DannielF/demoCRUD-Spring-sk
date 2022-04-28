package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRol;
import com.crud.democrud.services.UsuarioRolService;
import com.crud.democrud.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 *Routes CRUD UsuarioRol
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/usuario/rol")
public class UsuarioRolController {

    @Autowired
    UsuarioRolService usuarioRolService;

    private final Response response = new Response();
    private HttpStatus httpStatus = HttpStatus.OK;

    /**
     * Route get all usuarioRol
     * @return List of usuarioRol
     */
    @GetMapping()
    public ResponseEntity<Response> getAllUserRols() {
        response.restart();
        try {
            response.data = usuarioRolService.getUserRols();
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Route Find one usuarioRol
     * @param id Long
     * @return Entity
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getUserRolById(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = usuarioRolService.findById(id);
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Route Find usuarioRol by rol
     * @param rol String
     * @return Entity
     */
    @GetMapping("/query")
    public ResponseEntity<Response> getUserRolByRol(@RequestParam(value = "rol") String rol) {
        response.restart();
        try {
            response.data = usuarioRolService.findByRol(rol);
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Route to create a usuarioRol
     * @param usuarioRol Object
     * @return Entity
     */
    @PostMapping()
    public ResponseEntity<Response> saveUserRol(@RequestBody UsuarioRol usuarioRol) {
        response.restart();
        try {
            response.data = usuarioRolService.saveUserRol(usuarioRol);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Route to update a usuarioRol
     * @param usuarioRol Object
     * @param id Long
     * @return Entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUserRol(@RequestBody UsuarioRol usuarioRol, @PathVariable(value = "id") Long id) {

        response.restart();
        try {
            response.data = usuarioRolService.updateUserRol(id, usuarioRol);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Route to delete a usuarioRol
     * @param id Long
     * @return Entity
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> deleteUserRol(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = usuarioRolService.deleteUserRol(id);
            if (response.data == null) {
                response.message = "El contacto no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El contacto fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Administrador para las excepciones a nivel de SQL con respecto al manejo del acceso a los datos
     *
     * @param exception Objeto DataAccessException
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if (exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "El dato ya está registrado";
                    break;
                case 1452:
                    response.message = "El usuario indicado no existe";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * Administrador para las excepciones del sistema
     *
     * @param exception Objeto Exception
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
