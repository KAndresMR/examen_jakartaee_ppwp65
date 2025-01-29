package ec.edu.ups.jakarta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    private String cedula;
    private String nombre;
    private String binomio;

    public Candidate() {}

    public Candidate(String cedula, String nombre, String binomio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.binomio = binomio;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getBinomio() {
        return binomio;
    }
    public void setBinomio(String binomio) {
        this.binomio = binomio;
    }

    
    
}
