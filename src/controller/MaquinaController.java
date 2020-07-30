package controller;

import application.OperationalComponents;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MaquinaController {

    @FXML
    private TextField tfOS, tfHDlivre, tfHDPorc, tfRAMlivre, tfRAMocupada, tfPlacaRede;

    @FXML
    private TextArea taProcessos;
    

    @FXML
    void search(MouseEvent event) {
		tfOS.setText(OperationalComponents.getOperationalSystem());
		tfHDlivre.setText(OperationalComponents.getPathFreeSize("C:") + " bytes");
		tfHDPorc.setText(OperationalComponents.getPathFreePercent("C:") + " %");
		tfRAMlivre.setText(OperationalComponents.getMemoryUsedSize()  + " bytes");
		tfRAMocupada.setText(OperationalComponents.getMemoryFreePercent() + " %");
		tfPlacaRede.setText(OperationalComponents.getNetBoard());	
		taProcessos.setText(OperationalComponents.getRunningProcess("/C"));
    }
    
}