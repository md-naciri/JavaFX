module org.productmanager.productmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.productmanager.productmanager to javafx.fxml;
    exports org.productmanager.productmanager;
}