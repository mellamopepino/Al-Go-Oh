package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;

public abstract class ModoMonstruo {

    public abstract ResultadoCombate atacar(Monstruo otraCarta, Integer puntosAtaque);

    public ResultadoCombate recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        Integer diferenciaPuntos = puntosDefensivos(ataqueDefensor, defensaDefensor) - ataqueAtacante;

        if (diferenciaPuntos > 0)
            return perdioAtacante(diferenciaPuntos);
        if (diferenciaPuntos < 0)
            return ganoAtacante(diferenciaPuntos);
        return empataron();
    }

    public abstract Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor);

    public abstract ResultadoCombate ganoAtacante(Integer diferenciaPuntos);

    public abstract ResultadoCombate perdioAtacante(Integer diferenciaPuntos);

    public abstract ResultadoCombate empataron();
}