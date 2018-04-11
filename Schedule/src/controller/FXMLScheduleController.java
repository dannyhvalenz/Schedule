package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import jfxtras.scene.control.agenda.Agenda;
import model.DAO.ClaseDAO;
import model.DAO.EEDAO;
import model.pojos.Clase;
import model.pojos.EE;

/**
 * @author Daniela Hernandez Valenzuela
 * @since 08/04/2018
 * @version 1.2
 */

public class FXMLScheduleController implements Initializable {
    
    @FXML
    private StackPane sp_schedule;
    
    @FXML
    private AnchorPane ap_schedule;
    
    @FXML
    private AnchorPane ap_title;
    
    @FXML
    private JFXHamburger hamburger_menu;
    
    //@FXML
    //private ImageView icon_more;
            
    @FXML
    private Label lbl_title;
    
    @FXML
    private AnchorPane ap_agenda;
    
    @FXML
    private Agenda agenda;

    @FXML
    private JFXButton btn_nuevaClase;

    private List<EE> experiencias;
    private List<Clase> clases;
    private final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap 
            = new TreeMap<String, Agenda.AppointmentGroup>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXCheckBox ch = new JFXCheckBox();
        ch.setSelected(false);
        
        for (Agenda.AppointmentGroup lAppointmentGroup : agenda.appointmentGroups()) {
            lAppointmentGroupMap.put(lAppointmentGroup.getDescription(), lAppointmentGroup);
        }
        cargar();
        //TODO: Agregar vista del evento
        agenda.setActionCallback(new Callback<Agenda.Appointment, Void>() {
            @Override
            public Void call(Agenda.Appointment clase) {
                System.out.println(clase.getLocation());
                System.out.println(clase.getAppointmentGroup());
                return null;
            }
        });
        agenda.allowDraggingProperty().bind(ch.selectedProperty());
        agenda.allowResizeProperty().bind(ch.selectedProperty());
        
        //Restringir Click Derecho
        agenda.addEventFilter(MouseEvent.MOUSE_PRESSED, ev -> {
            if (ev.getButton() == MouseButton.SECONDARY) {
                ev.consume();
            }
        });
    }

    public void cargar() {
        agenda.appointments().clear();
        experiencias = EEDAO.getAllEEs();
        clases = ClaseDAO.getAllClases();
        int i;
        for (Clase c : clases) {
            i = c.getIdEE();
            System.out.println(i);
            c.setAppointmentGroup(lAppointmentGroupMap.get("group" + (i < 10 ? "0" : "") + i));
        }
        agenda.appointments().addAll(clases);
    }
    
    @FXML
    void agregarClase(ActionEvent event) {
        
    }   
    
}
