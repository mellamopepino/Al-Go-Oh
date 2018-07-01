package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.*;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class VistaInformacionCartaEnJuego {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;
    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaCartaCampo vistaCartaCampo;
    private MenuItem menuCambiarPosicion;
    private MenuItem menuActivarEfecto;
    private MenuItem menuModo;
    private ContextMenu menuOpciones;
    private MenuBar menuBar;

    public VistaInformacionCartaEnJuego(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo){
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;

    }
    public void dibujar(MouseEvent evento) {
        menuOpciones = new ContextMenu();

        if (carta.getEstadoCarta() instanceof BocaAbajo) {
            menuCambiarPosicion = new MenuItem("Girar carta");
            menuCambiarPosicion.setOnAction(new ControladorBocaArribaEnJuego(vistaCarta, jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos, vistaCartaCampo));

            menuOpciones.getItems().add(menuCambiarPosicion);
        }

        if (carta instanceof Monstruo) {
            menuModo = new MenuItem("Cambiar modo");
            menuModo.setOnAction(new ControladorCambiarModo(vistaCarta,carta,vistaZonaMonstruos));

            menuOpciones.getItems().add(menuModo);
        }

        
        menuActivarEfecto = new MenuItem("Activar efecto");
        menuActivarEfecto.setOnAction(new ControladorActivarEfecto(carta));

        menuOpciones.getItems().add(menuActivarEfecto);

        menuBar = new MenuBar();

        menuBar.setContextMenu(menuOpciones);

        menuOpciones.show(vistaCarta,evento.getScreenX(),evento.getScreenY());
    }

    public void update(MouseEvent evento) {
        this.dibujar(evento);
    }

}


