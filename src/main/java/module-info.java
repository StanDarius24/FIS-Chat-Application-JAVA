module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfxrt;
    requires rt;

    opens sample to javafx.fxml;
    exports sample;
}