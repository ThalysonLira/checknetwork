package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TemplateController implements Initializable {
	
	@FXML
    private AnchorPane ap;
	
	public static Parent maquina;

    @FXML
    void openAbout(MouseEvent event) {

    }

    @FXML
    void openConfiguration(MouseEvent event) {

    }

    @FXML
    void openLocalMachine(MouseEvent event) throws IOException {
    	Node node;
    	node = (Node)FXMLLoader.load(getClass().getResource("../view/maquina.fxml"));
    	ap.getChildren().setAll(node);
    }

    @FXML
    void openLocalNetwork(MouseEvent event) throws IOException {
    	Node node;
    	node = (Node)FXMLLoader.load(getClass().getResource("../view/rede.fxml"));
    	ap.getChildren().setAll(node);
    }

    @FXML
    void openNetwork(MouseEvent event) {

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}