package algo3.fiuba.cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.efectos_cartas.EfectoNulo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.modo_monstruo.ModoDeAtaque;
import algo3.fiuba.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.cartas.modo_monstruo.ModoMonstruo;

public class Monstruo extends Carta {

    private Integer ataque;
    private Integer defensa;
    private ModoMonstruo modoMonstruo;

    public Monstruo(String nombre, Integer ataque, Integer defensa) {
        super(nombre,new EfectoNulo());
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void atacar(Monstruo otraCarta) {
        ResultadoCombate resultadoCombate = modoMonstruo.atacar(otraCarta, ataque);
        resultadoCombate.afectarAtacante(this);
    }

    public ResultadoCombate recibirAtaque(Integer puntosAtaqueRival) {
        ResultadoCombate resultadoCombate = modoMonstruo.recibirAtaque(puntosAtaqueRival, ataque, defensa);
        resultadoCombate.afectarDefensor(this);
        return resultadoCombate;
    }

    public boolean estaVivo() {
        return estadoCarta.estaViva();
    }

    public void pasarAModoAtaque() {
        modoMonstruo = ModoDeAtaque.getInstancia();
    }

    public void pasarAModoDefensa() {
        modoMonstruo = ModoDeDefensa.getInstancia();
    }

    public void matarMonstruo() {
        estadoCarta = new EnCementerio();
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void daniarJugador(Integer puntosDeDanio) {
        jugador.modificarPuntosDeVida(-puntosDeDanio);
    }

    public void colocarEnCampo(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
        modoMonstruo = ModoDeAtaque.getInstancia();
    }

    public void cambiarModo() {
        modoMonstruo = modoMonstruo.cambiarModoMonstruo();
    }
}
