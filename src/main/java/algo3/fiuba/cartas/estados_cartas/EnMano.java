package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class EnMano extends FueraDeJuego {

    private static EnMano INSTANCIA;

    private EnMano() {

    }

    public static EnMano getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new EnMano();
        return INSTANCIA;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        throw new InhabilitadoParaAtacarExcepcion("No puede atacar si está en la mano.");
    }
}
