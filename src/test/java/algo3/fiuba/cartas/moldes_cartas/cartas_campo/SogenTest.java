package algo3.fiuba.cartas.moldes_cartas.cartas_campo;


import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SogenTest {
    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);
    }


    @Test
    public void colocoMonstruoACadaLadoDeCampoActivoCartaCampoSogenSeEfectuaUnAtaqueLos2QuedanVivos() {
        Monstruo monstruo1 = new Monstruo("Monstruo 1",500,0,1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Monstruo 2",0,200,1, new EfectoNulo());

        CartaCampo sogen = new Sogen(jugador2, jugador1);

        jugador1.colocarCartaEnCampo(monstruo1, BocaArriba.getInstancia());
        jugador2.colocarCartaEnCampo(monstruo2, BocaArriba.getInstancia());
        monstruo2.pasarAModoDefensa();

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnCampo(sogen, BocaArriba.getInstancia());

        monstruo1.atacar(monstruo2);

        //Deberian estar los 2 en juego ya que al activarse el efecto quedaron igualados en atk vs def y en ese caso no mueren en combate
        Assert.assertTrue(monstruo1.estaEnJuego());
        Assert.assertTrue(monstruo2.estaEnJuego());
    }

}