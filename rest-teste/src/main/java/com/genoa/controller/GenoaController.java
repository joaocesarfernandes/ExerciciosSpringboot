package com.genoa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoa.api.version.ApiVersion;
import com.genoa.model.*;
import com.genoa.repository.*;
import com.google.common.base.Stopwatch;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.genoa.model.ModelGenoa.DATE_FORMATTER;

/**
 * Created by valdisnei on 25/09/16.
 */
@RestController
@RequestMapping(ApiVersion.BASE_URL)
public class GenoaController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsuarioRepository catalogoRepository;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = {"/v1/{operation}/{lote}","/v2/{operation}/{lote}","/v3/{operation}/{lote}"},method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public String consultaNumeroLote(@PathVariable("operation") String operation,
                    @PathVariable("lote") String lote) throws JsonProcessingException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        String json = findFromDB(operation,Long.parseLong(lote));

        Stopwatch stop = stopwatch.stop();

        long elapsed = stop.elapsed(TimeUnit.MILLISECONDS);

        if (elapsed==0){
            logger.info(operation + " - tempo estimado: {} nano segundos ", stop.elapsed(TimeUnit.NANOSECONDS));
        }

        if (elapsed >1000){
            logger.info(operation + " - tempo estimado: {} segundos ", stop.elapsed(TimeUnit.SECONDS));
        }else{
            logger.info(operation + " - tempo estimado: {} mili segundos ", elapsed);
        }

        return json;
    }


    @RequestMapping(value = {"/v1/{operation}/lote/{dataInicial}","/v2/{operation}/lote/{dataInicial}","/v3/{operation}/lote/{dataInicial}"},method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public String listaLote(@PathVariable("operation") String operation,
        @PathVariable("dataInicial") String dataInicial) throws JsonProcessingException {
        LocalDate localDate = null;
        try{
            localDate = LocalDate.parse(dataInicial, DATE_FORMATTER);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return objectMapper.writeValueAsString(
                new Status(Response.SC_BAD_REQUEST, "Data Inválida!", null));

        }

        String json;
        List<Lote> lotes = getLotes(operation,localDate);
        if (lotes.isEmpty()) {
                return objectMapper.writeValueAsString(
                    new Status(Response.SC_NO_CONTENT, "Não foram encontrado lotes para esta data!", null));
            }

        String dataLoteString = lotes.get(0).getDataLote().format(DATE_FORMATTER);
        Result result = new Result(null,null,dataLoteString,
                                    null,null,Long.valueOf(lotes.size()), lotes
                                    );
        json = objectMapper.writeValueAsString(result);

        return json;
    }

}
