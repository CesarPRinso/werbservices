package com.tecsup.webservice.rest;

import com.tecsup.webservice.model.Programa;
import java.util.List;

public interface ProgramaService {
    
    List<Programa> listPrograma();
    
    Programa get(Long id);
    
    void save(Programa programa);
    
    void delete(Programa programa);
    
}
