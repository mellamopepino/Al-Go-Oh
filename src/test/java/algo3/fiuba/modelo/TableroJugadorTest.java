package algo3.fiuba.modelo;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableroJugadorTest {

    private TableroJugador tableroJugador;
    private Jugador jugador;


    @Before
    public void setUp() {
        tableroJugador = new TableroJugador();
        jugador = new Jugador();
        jugador.setOponente(new Jugador());
    }



    @Test
    public void seAgrega1Monstruo_elMonstruoEstaEnElTablero() {
        Monstruo carta = new BebeDragon(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertTrue(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaMagica_laCartaMagicaEstaEnElTablero() {
        Magica carta = new AgujeroNegro(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertTrue(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaTrampa_laCartaTrampaEstaEnElTablero() {
        Trampa carta = new Refuerzos(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertTrue(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaCampo_laCartaCampoEstaEnElTablero() {
        CartaCampo carta = new Wasteland(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());

        Assert.assertTrue(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1MonstruoYLuegoSeRemueve_elMonstruoNoEstaEnElTablero() {
        Monstruo carta = new BebeDragon(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());
        tableroJugador.removerCartaDelCampo(carta);

        Assert.assertFalse(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaMagicaYLuegoSeRemueve_laCartaMagicaNoEstaEnElTablero() {
        Magica carta = new AgujeroNegro(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());
        tableroJugador.removerCartaDelCampo(carta);

        Assert.assertFalse(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaTrampaYLuegoSeRemueve_laCartaTrampaNoEstaEnElTablero() {
        Trampa carta = new Refuerzos(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());
        tableroJugador.removerCartaDelCampo(carta);

        Assert.assertFalse(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaCampoYLuegoSeRemueve_laCartaCampoNoEstaEnElTablero() {
        CartaCampo carta = new Wasteland(jugador);
        tableroJugador.colocarCartaEnCampo(carta, new BocaAbajo());
        tableroJugador.removerCartaDelCampo(carta);

        Assert.assertFalse(tableroJugador.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaCampoYLuegoSeAgregaOtra_quedaLaSegundaYLaPrimeraQuedaEnElCementerio() {
        CartaCampo cartaCampo1 = new Wasteland(jugador);
        CartaCampo cartaCampo2 = new Sogen(jugador);

        tableroJugador.colocarCartaEnCampo(cartaCampo1, new BocaArriba());
        tableroJugador.colocarCartaEnCampo(cartaCampo2, new BocaArriba());

        Assert.assertFalse(tableroJugador.cartaEstaEnCampo(cartaCampo1));
        Assert.assertTrue(tableroJugador.cartaEstaEnCampo(cartaCampo2));

    }
}
