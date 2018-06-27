package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMazo;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class VistaMazo extends Label {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    Label nroCartas;

    // LE PODEMOS PASAR CON EL CONTROLADOR EL NUMERO DE CARTAS
    public VistaMazo(ImageView fondoMazo) {

        this.setText("40");
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorMazo());
    }

    public void actualizarCantidad(Integer tam) {
        //this.setText(/* npi coomo se pasa el integer a str*/);
    }

}
