package edu.eci.ieti.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.eci.ieti.mongodb.model.Documento;
import edu.eci.ieti.mongodb.service.DocumentService;

@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/documents")
    public ResponseEntity<List<Documento>> getAll() {
        return new ResponseEntity<List<Documento>>(documentService.getAll(), HttpStatus.ACCEPTED);
    } 

    @GetMapping("/documents/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<Documento>(documentService.findByName(name), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se ha encontrado el documento...  " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/documents/newDocument/{name}/{description}")
    public ResponseEntity<?> save(@PathVariable("name") String name, @PathVariable("description") String description) {
        try {
            documentService.save(new Documento(name,description));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido crear el documento...  " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/documents/deleteAll")
    public ResponseEntity<?> deleteAll() {
        try {
            documentService.deleteAll();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("No se ha podido eliminar los documentos...  " + e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    
}
