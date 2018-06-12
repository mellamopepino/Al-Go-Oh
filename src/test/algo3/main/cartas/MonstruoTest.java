package test.algo3.main.cartas;

import main.algo3.fiuba.cartas.*;
import org.junit.Assert;
import org.junit.Test;

public class MonstruoTest {

    @Test(expected = RuntimeException.class)
    public void monstruoNoPuedeAtacarEnModoDefensa() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoDefensa();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

        monstruoAtacante.atacar(monstruoDefensor);
    }

    @Test
    public void monstruoEnModoAtaquePuedeAtacarAMonstruoEnJuego() {
        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", 1000, 1000);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 1500, 1500);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertFalse(monstruoDefensor.estaVivo());
    }

    @Test
    public void atacarAMonstruoEnModoDefensa_DefensorTieneMasPuntosDeDefensa_NoMuereNadie() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", 0, puntosDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoDefensa();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertTrue(monstruoDefensor.estaVivo());
    }


    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMenosPuntosDeAtaque_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertTrue(monstruoAtacante.estaVivo());
        Assert.assertFalse(monstruoDefensor.estaVivo());
    }

    @Test
    public void atacarAMonstruoEnModoAtaque_DefensorTieneMasPuntosDeAtaque_MuereElAtacante() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);
        Assert.assertFalse(monstruoAtacante.estaVivo());
        Assert.assertTrue(monstruoDefensor.estaVivo());
    }





}
