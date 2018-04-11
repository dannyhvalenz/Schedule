package model.pojos;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import jfxtras.scene.control.agenda.Agenda.AppointmentImplLocal;
import model.DAO.EEDAO;

/**
 * Clase principal para modelar las Clases con la BD
 * @author Daniela Hernandez Valenzuela
 * @since 07/04/2018
 * @version 1.1
 */

public class Clase extends AppointmentImplLocal {
    private Integer idClase;
    private String nombre;
    private Integer idEE;
    
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getIdEE() {
        return idEE;
    }

    public void setIdEE(Integer idEE) {
        this.idEE = idEE;
    }

    public Clase(Integer idClase, Integer idEE, String nombre, String dia, Time horaInicio, Time horaFin, String salon, String nota) {
        super();
        int cant = 0;
        switch (dia) {
        case "Lunes":
            cant = 0;
            break;
        case "Martes":
            cant = 1;
            break;
        case "Miercoles":
            cant = 2;
            break;
        case "Jueves":
            cant = 3;
            break;
        case "Viernes":
            cant = 4;
            break;
        case "Sabado":
            cant = 5;
            break;
        case "Domingo":
            cant = 6;
            break;
        }
        this.idEE = idEE;
        this.setStartLocalDateTime(LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 9 + cant), horaInicio.toLocalTime()));
        this.setEndLocalDateTime(LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 9 + cant), horaFin.toLocalTime()));
        this.setLocation(salon);
        this.setSummary(nombre);
        this.setDescription(nota);
    }
}