package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCarta extends Label {

    private VistaCartaCampo vistaCartaCampo;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaMano vistaMano;
    private Carta carta;
    private Jugador jugador;
    private ImageView imagenCarta;
    private ImageView imagenCartaBocaAbajo;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private boolean bocaAbajo;

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {

        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png", ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        bocaAbajo = false;
        this.dibujar();
    }

    public void dibujar() {
        if (bocaAbajo) this.setGraphic(imagenCartaBocaAbajo);
        else this.setGraphic(imagenCarta);

        this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta, vistaMano, vistaZonaNoMonstruos, vistaZonaMonstruos, vistaCartaCampo));
    }

    public void deshabilitarCarta() {
        this.setDisable(true);
    }

    public void update() {
        this.dibujar();
    }

    public double getAlturaCarta() {
        return ALTURA_MAXIMA_CARTA;
    }

    public double getAnchoCarta() {
        return ANCHO_MAXIMO_CARTA;
    }

    public void cambiarVision() {
        bocaAbajo = !bocaAbajo;
    }



}
