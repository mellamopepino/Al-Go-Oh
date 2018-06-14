package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.efectos_cartas.EfectoCarta;

public class BocaAbajo extends EnJuego {

    private static BocaAbajo INSTANCIA;

    private BocaAbajo() {
    }

    public static BocaAbajo INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new BocaAbajo();
        }

        return INSTANCIA;
    }

    @Override
    public void activar(EfectoCarta efecto) {
        throw new RuntimeException("No se puede activar efecto de una carta boca abajo");
    }
}