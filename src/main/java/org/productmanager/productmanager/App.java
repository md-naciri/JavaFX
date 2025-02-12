package org.productmanager.productmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);

        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());

        stage.setTitle("Gestion des Produits");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
