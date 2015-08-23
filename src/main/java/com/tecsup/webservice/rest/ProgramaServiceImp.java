package com.tecsup.webservice.rest;

import com.tecsup.webservice.dao.ProgramaDAO;
import com.tecsup.webservice.model.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProgramaServiceImp implements ProgramaService {

    @Autowired
    ProgramaDAO programaDAO;

    @Override
    public List<Programa> listPrograma() {
        return programaDAO.list();
    }

    @Override
    public Programa get(Long id) {
        return programaDAO.get(id);
    }

    @Override
    public void save(Programa programa) {

        if (programa.getId() == null) {
            programaDAO.save(programa);
        } else {
            programaDAO.update(programa);
        }
    }

    @Override
    public void delete(Programa programa) {
        programaDAO.delete(programa);
    }

}
