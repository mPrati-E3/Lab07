package it.polito.tdp.poweroutages;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Nerc> dropNERC;

    @FXML
    private TextField txtYEARS;

    @FXML
    private TextField txtHours;

    @FXML
    private Button btnWCA;

    @FXML
    private TextArea txtStampa;

    @FXML
    private TableView<PowerOutages> tblStampa;

    @FXML
    private TableColumn<PowerOutages, Integer> colYear;
    
    @FXML
    private TableColumn<PowerOutages, LocalDate> colBegin;

    @FXML
    private TableColumn<PowerOutages, LocalDate> colFinished;

    @FXML
    private TableColumn<PowerOutages, Integer> colCustomers;
    
    @FXML
    private ImageView imgMap;

    @FXML
    void doWCA(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert dropNERC != null : "fx:id=\"dropNERC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtYEARS != null : "fx:id=\"txtYEARS\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtHours != null : "fx:id=\"txtHours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnWCA != null : "fx:id=\"btnWCA\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblStampa != null : "fx:id=\"tblStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colYear != null : "fx:id=\"colYear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colBegin != null : "fx:id=\"colBegin\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colFinished != null : "fx:id=\"colFinished\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colCustomers != null : "fx:id=\"colCustomers\" was not injected: check your FXML file 'Scene.fxml'.";
        assert imgMap != null : "fx:id=\"imgMap\" was not injected: check your FXML file 'Scene.fxml'.";
        
        imgMap.setImage(new Image("NERC-map.png"));
    }
    
    public void setModel (Model m) {
    	this.model=m;
    }
}
