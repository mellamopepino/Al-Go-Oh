package algo3.fiuba.modelo;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;
import algo3.fiuba.utils.MazoUtils;

import java.util.Stack;

public class Juego {

    private static Juego INSTANCIA;

    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;

    private Juego() {
        turno = Turno.getInstancia();
    }

    public static Juego getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new Juego();

        return INSTANCIA;
    }

    public void inicializar(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        turno.addObserver(jugador1);
        turno.addObserver(jugador2);

        jugador1.setEstadoJugador(new PreInvocacion());
        jugador2.setEstadoJugador(new TurnoDelOponente());
    }

    public boolean terminoPartida(){
        return !(jugador1.estaEnJuego() && jugador2.estaEnJuego());
    }

    public Jugador ganadorPartida() {
        if (this.terminoPartida()) return jugador1.estaEnJuego() ? jugador1 : jugador2;
        return null;
    }
    
    public void inicializarMazos(Stack<Carta> mazoJugador1, Stack<Carta> mazoJugador2) {
        jugador1.setMazo(mazoJugador1);
        jugador2.setMazo(mazoJugador2);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void inicializarManos() {
        for(int i = 0; i < 5; i++) {
            jugador1.tomarCartaDelMazo();
            jugador2.tomarCartaDelMazo();
        }
    }
}
