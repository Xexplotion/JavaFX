module com.xexplotion.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.xexplotion.javafx to javafx.fxml;
    exports com.xexplotion.javafx;
}