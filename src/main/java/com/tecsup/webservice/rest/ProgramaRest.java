package com.tecsup.webservice.rest;

import com.tecsup.webservice.model.Programa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("rest/programa")
public class ProgramaRest {

    @Autowired
    ProgramaService service;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Programa> list() {
        return service.listPrograma();
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Programa findById(@PathVariable("id") Long programa) {
        return service.get(programa);
    }

    @ResponseBody
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> eliminar(@PathVariable("id") Long id) {
        Map<String, Object> resultado = new HashMap();

        try {
            service.delete(new Programa(id));
            resultado.put("estado", true);

        } catch (Exception e) {
            resultado.put("estado", false);
            System.out.println(e.getMessage());
        }

        return resultado;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> insertar(Programa programa) {

        Map<String, Object> resultado = new HashMap();
        try {
            service.save(programa);
            resultado.put("estado", true);

        } catch (Exception e) {
            resultado.put("estado", false);
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> actualizar(Programa programa) {

        Map<String, Object> resultado = new HashMap();
        try {

            service.save(programa);
            resultado.put("estado", true);
        } catch (Exception e) {
            resultado.put("estado", false);
            System.out.println(e.getMessage());
        }
        return resultado;
    }

}
