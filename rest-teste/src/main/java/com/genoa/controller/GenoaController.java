package com.genoa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoa.api.version.ApiVersion;
import com.genoa.model.Usuario;
import com.genoa.repository.UsuarioRepository;

@RestController
public class GenoaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String consultaNumeroLote() {

    	Usuario usu = new Usuario();
        usu.setNome("joao");
        usu.setIdade(26);
        
        usuarioRepository.save(usu);
        
        return "201";
    }

}
