package controller;

import application.NetworkPing;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RedeController {

    @FXML
    private TextField tfConectado, tfIPinterno, tfHost, tfIPexterno;

    @FXML
    void search(MouseEvent event) {
    	tfConectado.setText(NetworkPing.isConnected());
    	tfIPinterno.setText(NetworkPing.getIpInternal());
    	tfHost.setText(NetworkPing.getHostName());
    	tfIPexterno.setText(NetworkPing.getIpExternal());
    }
    
}