module com.example.demoproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires spring.security.crypto;


    opens com.example.demoproj to javafx.fxml;
    exports com.example.demoproj;
    exports com.example.demoproj.controller;
    exports com.example.demoproj.util;
    opens com.example.demoproj.controller to javafx.fxml;
}