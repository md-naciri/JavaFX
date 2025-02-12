package org.productmanager.productmanager;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class ProductController {
    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPrix;

    @FXML
    private ListView<Product> listView;

    private final ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(productList);
    }

    @FXML
    public void addProduct() {
        String name = textFieldNom.getText();
        String priceText = textFieldPrix.getText();

        if (name.trim().isEmpty() || priceText.trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez remplir tous les champs !");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            Product product = new Product(name, price);
            productList.add(product);

            textFieldNom.clear();
            textFieldPrix.clear();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Le prix doit être un nombre valide !");
        }
    }

    @FXML
    public void deleteProduct() {
        Product selectedProduct = listView.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Veuillez sélectionner un produit !");
        } else {
            productList.remove(selectedProduct);
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}
