package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.efectos.EfectoWasteland;

public class Wasteland extends CartaCampo {

    public Wasteland(Jugador jugador) {
        super("Wasteland", new EfectoNulo());
        super.setEfecto(new EfectoWasteland(this, jugador));
        setJugador(jugador);
    }
}
