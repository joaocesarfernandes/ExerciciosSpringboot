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
    private VendasRepository vendasRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private RecebimentoRepository recebimentoRepository;

    @Autowired
    private FaturamentoRepository faturamentoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private CatalogoStatusRepository catalogoStatusRepository;

    @Autowired
    private LoteRepository loteRepository;

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

    private List<Lote> getLotes(String operation,LocalDate localDate) {
        List<Lote> lotes=null;
        switch (operation.toUpperCase()) {
        case "VENDA":
            lotes = loteRepository.listLoteVendas(localDate);
            break;
        case "COMPRA":
            lotes = loteRepository.listLoteCompra(localDate);
            break;
        case "FATURAMENTO":
            lotes = loteRepository.listLoteFaturamento(localDate);
            break;
        case "ESTOQUE":
            lotes = loteRepository.listLoteEstoque(localDate);
            break;
        case "RECEBIMENTO":
            lotes = loteRepository.listLoteRecebimento(localDate);
            break;
        case "CATALOGO":
            lotes = loteRepository.listLoteCatalogo(localDate);
            break;
        case "CATALOGO-STATUS":
            lotes = loteRepository.listLoteCatalogoStatus(localDate);
            break;
        }
        return lotes;
    }

    private Map<String,Object> findByLote(String operation,Long lote) {
        Map<String,Object> map = new HashMap<String,Object>();


        switch (operation.toUpperCase()) {
        case "VENDA":
            List<Vendas> byLote = vendasRepository.findByLote(lote);
            if (byLote.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLote);
            map.put("COUNT",vendasRepository.count(byLote.get(0).getDataLote()));
            map.put("DATALOTE",byLote.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        case "COMPRA":
            List<Compra> byLoteCompra = compraRepository.findByLote(lote);
            if (byLoteCompra.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteCompra);
            map.put("COUNT",compraRepository.count(byLoteCompra.get(0).getDataLote()));
            map.put("DATALOTE",byLoteCompra.get(0).getDataLote().format(DATE_FORMATTER));
            break;
        case "FATURAMENTO":
            List<Faturamento> byLoteFaturamento = faturamentoRepository.findByLote(lote);
            if (byLoteFaturamento.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteFaturamento);
            map.put("COUNT",faturamentoRepository.count(byLoteFaturamento.get(0).getDataLote()));
            map.put("DATALOTE",byLoteFaturamento.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        case "RECEBIMENTO":
            List<Recebimento> byLoteRecebimento = recebimentoRepository.findByLote(lote);
            if (byLoteRecebimento.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteRecebimento);
            map.put("COUNT",recebimentoRepository.count(byLoteRecebimento.get(0).getDataLote()));
            map.put("DATALOTE",byLoteRecebimento.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        case "ESTOQUE":
            List<Estoque> byLoteEstoque = estoqueRepository.findByLote(lote);
            if (byLoteEstoque.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteEstoque);
            map.put("COUNT",estoqueRepository.count(byLoteEstoque.get(0).getDataLote()));
            map.put("DATALOTE",byLoteEstoque.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        case "CATALOGO":
            List<Catalogo> byLoteCatalogo = catalogoRepository.findByLote(lote);
            if (byLoteCatalogo.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteCatalogo);
            map.put("COUNT",catalogoRepository.count(byLoteCatalogo.get(0).getDataLote()));
            map.put("DATALOTE",byLoteCatalogo.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        case "CATALOGO-STATUS":
            List<CatalogoStatus> byLoteCatalogoStatus = catalogoStatusRepository.findByLote(lote);
            if (byLoteCatalogoStatus.isEmpty())
                return Collections.emptyMap();

            map.put("LIST", byLoteCatalogoStatus);
            map.put("COUNT",catalogoStatusRepository.count(byLoteCatalogoStatus.get(0).getDataLote()));
            map.put("DATALOTE",byLoteCatalogoStatus.get(0).getDataLote().format(DATE_FORMATTER));

            break;
        }
        return map;
    }

    private String findFromDB(String operation, Long lote) throws JsonProcessingException {
        Map<String, Object> byLote = findByLote(operation, lote);

        if (byLote.isEmpty()) {
            return objectMapper.writeValueAsString(
                new Status(Response.SC_NO_CONTENT,"Lote Não Encontrado!",null));
        }

        List all = (List) byLote.get("LIST");

        Long totalRegistrosGeral = (Long) byLote.get("COUNT");

        String dataLote = (String) byLote.get("DATALOTE");

        Result result = new Result(lote,null,
            dataLote, totalRegistrosGeral, Long.valueOf(all.size()), null, all);

        return objectMapper.writeValueAsString(result);
    }


}
