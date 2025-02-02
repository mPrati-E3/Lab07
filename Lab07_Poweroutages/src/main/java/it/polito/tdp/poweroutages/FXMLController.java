package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.Date;
import java.util.List;
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
    private TableColumn<PowerOutages, Date> colBegin;

    @FXML
    private TableColumn<PowerOutages, Date> colFinished;

    @FXML
    private TableColumn<PowerOutages, Integer> colCustomers;
    
    @FXML
    private ImageView imgMap;
    
    //funzione di stampa, prende un a lista e la mette nella text area, non fa altro
	private void Stampante(List<PowerOutages> L) {
    	
    	for (PowerOutages po : L) {
    		txtStampa.appendText(po.getYear()+" - ");
    		txtStampa.appendText(po.getBegin()+"  --->  ");
    		txtStampa.appendText(po.getFinished()+"  >>> Costumers: ");
    		txtStampa.appendText(po.getCustomers()+"\n");
    	}
    	
    }

	//quando premo il pulsante, controllo le varie text field e drop poi chiamo il metodo operativo del modello
	@FXML
    void doWCA(ActionEvent event) {
    	
    	txtStampa.clear();
    	
    	Nerc N = dropNERC.getValue();
    	if (N==null) {
    		txtStampa.appendText("Choose a NERC! \n");
    		return;
    	}
    	
    	int Y=0;
    	int H=0;
    	try {
    		Y = Integer.parseInt(txtYEARS.getText());
    		H = Integer.parseInt(txtHours.getText());
    	} catch (NumberFormatException e) {
    		txtStampa.appendText("Years and hours must be numeric! \n");
    		return;
    	}
    	
    	List<PowerOutages> PO = this.model.faiWCA(N,Y,H);
    	
    	if (PO!=null && !(PO.isEmpty())) {
    		this.Stampante(PO);
    	} else {
    		txtStampa.appendText("No result found \n");
    	}

    }

    @FXML
    void initialize() {
        assert dropNERC != null : "fx:id=\"dropNERC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtYEARS != null : "fx:id=\"txtYEARS\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtHours != null : "fx:id=\"txtHours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnWCA != null : "fx:id=\"btnWCA\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert imgMap != null : "fx:id=\"imgMap\" was not injected: check your FXML file 'Scene.fxml'.";
        
        //carico l'immagine della mappa
        imgMap.setImage(new Image("NERC-map.png"));
    }
    
    public void setModel (Model m) {
    	this.model=m;
    	
    	//metto nel drop i valori NERC, devo farlo qua perchè prima il modello non esiste
    	List<Nerc> N = this.model.getNercList();
    	
    	for (Nerc n : N) {
    		dropNERC.getItems().add(n);
    	}
    	
    	dropNERC.setValue(N.get(0));
    }
}
