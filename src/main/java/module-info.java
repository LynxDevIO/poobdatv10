module dev.phil.poobdatv10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.phil.poobdatv10 to javafx.fxml;
    exports dev.phil.poobdatv10;
    exports dev.phil.poobdatv10.view;
    opens dev.phil.poobdatv10.view to javafx.fxml;
    exports dev.phil.poobdatv10.controller;
    opens dev.phil.poobdatv10.controller to javafx.fxml;
}