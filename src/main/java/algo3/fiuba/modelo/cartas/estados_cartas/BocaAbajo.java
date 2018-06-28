package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

public class BocaAbajo extends EnJuego {

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        throw new CartaInhabilitadaParaActivarseExcepcion("No se puede activar efecto de una carta boca abajo");
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto) {
        activarEfecto(carta, efecto);
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        efecto.activar(trampa, atacante, atacado);
    }

    @Override
    public void recibirAtaque(Monstruo carta) {
        carta.setEstado(new BocaArriba());
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto){
        activarEfecto(carta, efecto);
    }

    @Override
    public void colocarCartaEnCampo(Magica carta, Campo campo) {
        campo.colocarCarta(carta, this);
    }
}
