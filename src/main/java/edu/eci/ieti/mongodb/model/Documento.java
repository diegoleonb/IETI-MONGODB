package edu.eci.ieti.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("documents")
public class Documento {

    @Id
    String name;
    String description;

    public Documento(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Documento() {
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

    
}
