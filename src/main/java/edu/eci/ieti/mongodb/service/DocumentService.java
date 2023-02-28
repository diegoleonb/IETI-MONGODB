package edu.eci.ieti.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.mongodb.model.Documento;
import edu.eci.ieti.mongodb.repository.DocumentRepository;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;


    public List<Documento> getAll() {
        return documentRepository.findAll();
    }

    public void save(Documento document) {
        documentRepository.save(document);
    }

    public Documento findByName(String name) {
        return documentRepository.findByName(name);
    }


    public void deleteByName(String name) {
        documentRepository.deleteByName(name);
    }

    public void deleteAll() {
        documentRepository.deleteAll();
    }

}
