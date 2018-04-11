package model.pojos;

/**
 * Clase principal para modelar las Experiencias Educativas con la BD
 * @author Daniela Hernandez Valenzuela
 * @since 08/04/2018
 * @version 1.1
 */

public class EE {
    private Integer idEE;
    private String nombre;
    private String profesor;

    public EE() {
    }

    public EE(Integer idEE, String nombre, String profesor) {
        this.idEE = idEE;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Integer getIdEE() {
        return idEE;
    }

    public void setIdEE(Integer idEE) {
        this.idEE = idEE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    } 
}