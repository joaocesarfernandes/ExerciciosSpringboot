package com.genoa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoa.api.version.ApiVersion;
import com.genoa.model.Usuario;
import com.genoa.repository.UsuarioRepository;

/**
 * Created by valdisnei on 25/09/16.
 */
@RestController
@RequestMapping(ApiVersion.BASE_URL)
public class GenoaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = {"/teste"},method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public String consultaNumeroLote(String nome, Integer idade) throws JsonProcessingException {

    	Usuario usu = new Usuario();
        usu.setNome(nome);
        usu.setIdade(idade);
        
        usuarioRepository.save(usu);
        
        return "201";
    }

}
