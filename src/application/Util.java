package application;

import java.net.SocketException;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Util extends Application {
	
	private static BorderPane root;

	public static void main(String args[]) throws UnknownHostException, SocketException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		root = FXMLLoader.load(getClass().getResource("../view/template.fxml"));
		
		Scene scene = new Scene(root, 900, 700);
		
		primaryStage.setTitle("Listagem de Recursos");
		primaryStage.getIcons().add(new Image("view/icons/conexão-24.png"));
		primaryStage.setScene(scene);		
		primaryStage.show();

	}

}