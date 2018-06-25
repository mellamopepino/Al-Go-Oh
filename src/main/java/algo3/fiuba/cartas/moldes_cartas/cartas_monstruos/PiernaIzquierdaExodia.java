package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.List;

public class PiernaIzquierdaExodia extends Monstruo {

    public PiernaIzquierdaExodia(Jugador jugador) {
        super("Pierna izquierda del prohibido", 200, 300, 1, new EfectoPartesExodia(jugador.getOponente()));
        setJugador(jugador);
    }

    @Override
    public void agregarAMano(List<Carta> mano) {
        super.agregarAMano(mano);
        activarEfecto(this, jugador);
    }

    @Override
    public void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        super.colocarEnCampo(campo, tipoEnJuego, sacrificios);
        efecto.desactivar();
    }
}
