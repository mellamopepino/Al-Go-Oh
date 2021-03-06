package algo3.fiuba.entrega2;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.Fisura;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega2Test {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        turno = Turno.getInstancia();
    }


    @Test
    public void colocoMonstruoACadaLadoDeCampo_activoCartaCampoWasteland_aumenta200ATKPropio_aumenta300DEFOponente() {
        CartaCampo wasteland = new Wasteland(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoOponente1 = new Kuriboh(jugador2);

        Integer ataqueInicialMonstruoPropio1 = monstruoPropio1.getAtaque();
        Integer defensaInicialMonstruoPropio1 = monstruoPropio1.getDefensa();
        Integer ataqueInicialMonstruoOponente1 = monstruoOponente1.getAtaque();
        Integer defensaInicialMonstruoOponente1 = monstruoOponente1.getDefensa();

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaAbajo());
        turno.pasarTurno();

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnCampo((Carta) wasteland, new BocaArriba());

        // Se suma 300 a la defensa del oponente y el ataque permanece igual.
        Integer ataqueFinalOponente = ataqueInicialMonstruoOponente1 + 0;
        Assert.assertEquals(ataqueFinalOponente, monstruoOponente1.getAtaque());
        Integer defensaFinalMonstruoOponente1 = defensaInicialMonstruoOponente1 + 300;
        Assert.assertEquals(defensaFinalMonstruoOponente1, monstruoOponente1.getDefensa());

        // Se suma 200 al ataque propio y la defensa permanece igual.
        Integer ataqueFinalMonstruoPropio1 = ataqueInicialMonstruoPropio1 + 200;
        Assert.assertEquals(ataqueFinalMonstruoPropio1, monstruoPropio1.getAtaque());
        Integer defensaFinalMonstruoPropio1 = defensaInicialMonstruoPropio1 + 0;
        Assert.assertEquals(defensaFinalMonstruoPropio1, monstruoPropio1.getDefensa());

        Monstruo monstruoPropio2 = new GuerreroCelta(jugador1);
        Monstruo monstruoOponente2 = new PezDe7Colores(jugador2);

        Integer ataqueInicialMonstruoPropio2 = monstruoPropio2.getAtaque();
        Integer defensaInicialMonstruoOponente2 = monstruoOponente2.getDefensa();

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());

        // El efecto de las cartas de campo se mantienen activas, aún para cartas agregadas después de colocar estas.
        // Se suma 300 a la defensa del oponente y el ataque permanece igual.
        Integer ataqueFinalMonstruoPropio2 = ataqueInicialMonstruoPropio2 + 200;
        Assert.assertEquals(ataqueFinalMonstruoPropio2, monstruoPropio2.getAtaque());
        Integer defensaFinalMonstruoOponente2 = defensaInicialMonstruoOponente2 + 300;
        Assert.assertEquals(defensaFinalMonstruoOponente2, monstruoOponente2.getDefensa());
    }


    @Test
    public void colocoMounstruoDeCadaLadoDeCampo_activoCartaCampoSogen_aumenta500DEFPropio_aumenta200ATKOponente() {
        CartaCampo sogen = new Sogen(jugador1);
        Monstruo monstruoPropio1 = new BebeDragon(jugador1);
        Monstruo monstruoOponente1 = new Kuriboh(jugador2);

        Integer ataqueInicialMonstruoPropio1 = monstruoPropio1.getAtaque();
        Integer defensaInicialMonstruoPropio1 = monstruoPropio1.getDefensa();
        Integer ataqueInicialMonstruoOponente1 = monstruoOponente1.getAtaque();
        Integer defensaInicialMonstruoOponente1 = monstruoOponente1.getDefensa();

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente1, new BocaAbajo());
        turno.pasarTurno();

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnCampo((Carta) sogen, new BocaArriba());

        // Se suma 500 a la defensa propia y el ataque permanece igual.
        Integer ataqueFinalMonstruoPropio1 = ataqueInicialMonstruoPropio1;
        Assert.assertEquals(ataqueFinalMonstruoPropio1, monstruoPropio1.getAtaque());
        Integer defensaFinalMonstruoPropio1 = defensaInicialMonstruoPropio1 + 500;
        Assert.assertEquals(defensaFinalMonstruoPropio1, monstruoPropio1.getDefensa());

        // Se suma 200 al ataque del oponente y la defensa permanece igual.
        Integer ataqueFinalOponente = ataqueInicialMonstruoOponente1 + 200;
        Assert.assertEquals(ataqueFinalOponente, monstruoOponente1.getAtaque());
        Integer defensaFinalMonstruoOponente1 = defensaInicialMonstruoOponente1;
        Assert.assertEquals(defensaFinalMonstruoOponente1, monstruoOponente1.getDefensa());

        Monstruo monstruoPropio2 = new GuerreroCelta(jugador1);
        Monstruo monstruoOponente2 = new PezDe7Colores(jugador2);

        Integer defensaInicialMonstruoPropio2 = monstruoPropio2.getDefensa();
        Integer ataqueInicialMonstruoOponente2 = monstruoOponente2.getAtaque();

        jugador1.colocarCartaEnCampo((Carta) monstruoPropio2, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoOponente2, new BocaArriba());

        // El efecto de las cartas de campo se mantienen activas, aún para cartas agregadas después de colocar estas.
        Integer defensaFinalMonstruoPropio2 = defensaInicialMonstruoPropio2 + 500;
        Assert.assertEquals(defensaFinalMonstruoPropio2, monstruoPropio2.getDefensa());
        Integer ataqueFinalMonstruoOponente2 = ataqueInicialMonstruoOponente2 + 200;
        Assert.assertEquals(ataqueFinalMonstruoOponente2, monstruoOponente2.getAtaque());
    }


    @Test
    public void activoCartaOllaDelaCodicia_TomoDosCartasDelMazo() {
        Carta carta1 = new BebeDragon(jugador1);
        Carta carta2 = new Kuriboh(jugador1);
        Magica ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);

        jugador1.agregarCartaAMazo(carta1);
        jugador1.agregarCartaAMazo(carta2);
        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaAbajo());

        ollaDeLaCodicia.activarEfecto();
        // Se agregaron dos cartas a la mano del jugador, sacadas del mazo de este.
        Assert.assertTrue(jugador1.cartaEstaEnMano(carta1));
        Assert.assertTrue(jugador1.cartaEstaEnMano(carta2));

        Integer cartasEnMano = 2;
        Assert.assertEquals(cartasEnMano, jugador1.cantidadCartasEnMano());
        Assert.assertEquals(0, jugador1.cantidadCartasEnMazo());

        // Luego de ser usada la carta mágica va al cementerio.
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(ollaDeLaCodicia));
    }

    @Test
    public void colocoDosCartasMonstruoEnCampoEnemigo_activoFisura_elDeMenorAtaqueEsDestruido() {
        Monstruo monstruoFuerte = new PezDe7Colores(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);
        Magica fisura = new Fisura(jugador1);

        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoDebil, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoFuerte, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) fisura, new BocaAbajo());

        fisura.activarEfecto();

        // Después de ser usada la carta mágica va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));

        // La carta de menor ataque del enemigo va al cementerio.
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));
    }

    @Test
    public void invocoAJinzo7_atacaDirectoALosPuntosDeVidaDelOponente() {
        Carta jinzo7 = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo(jinzo7, new BocaArriba());

        jinzo7.activarEfecto();

        // No se ataca a las cartas en el campo enemigo.

        // Se atacan los puntos de vida del oponente.
        Integer vidaFinalEnemigo = 8000 - 500;
        Assert.assertEquals(vidaFinalEnemigo, jugador2.getPuntosDeVida());

        // Después de atacar Jinzo7 se mantiene en el tablero.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(jinzo7));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(jinzo7));
    }

    @Test
    public void invocarDragonDefinitivo_seSacrifiacanTresDragonesBlancosOjosAzules() {
        Monstruo dragonASacrificar1 = new DragonBlancoDeOjosAzules(jugador1);
        Monstruo dragonASacrificar2 = new DragonBlancoDeOjosAzules(jugador1);
        Monstruo dragonASacrificar3 = new DragonBlancoDeOjosAzules(jugador1);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new PezDe7Colores(jugador1);
        Monstruo monstruoASacrificar2 = new PezDe7Colores(jugador1);
        Monstruo monstruoASacrificar3 = new PezDe7Colores(jugador1);
        Monstruo monstruoASacrificar4 = new PezDe7Colores(jugador1);
        Monstruo monstruoASacrificar5 = new PezDe7Colores(jugador1);
        Monstruo monstruoASacrificar6 = new PezDe7Colores(jugador1);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar1, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar2, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) dragonASacrificar1, new BocaAbajo(), monstruoASacrificar1, monstruoASacrificar2);
        turno.pasarTurno();
        turno.pasarTurno();

        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar3, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar4, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) dragonASacrificar2, new BocaAbajo(), monstruoASacrificar3, monstruoASacrificar4);
        turno.pasarTurno();
        turno.pasarTurno();

        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar5, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar6, new BocaAbajo());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) dragonASacrificar3, new BocaAbajo(), monstruoASacrificar5, monstruoASacrificar6);
        turno.pasarTurno();
        turno.pasarTurno();

        Carta dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador1);

        jugador1.colocarCartaEnCampo((Carta) dragonDefinitivo, new BocaArriba(), dragonASacrificar1, dragonASacrificar2, dragonASacrificar3);

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar1));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar2));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar3));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar3));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertTrue(dragonDefinitivo.estaEnJuego());
    }

    @Test
    public void colocoInsectoComeHombresBocaAbajo_monstruoOponenteLoAtaca_seActivaEfectoYSeDestruyeAtacante() {
        Monstruo insectoComeHombres = new InsectoComeHombres(jugador1);
        Monstruo monstruoAtacante = new BebeDragon(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaAbajo());
        insectoComeHombres.pasarAModoDefensa();
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(insectoComeHombres);

        Integer puntosInicialesDeVida = 8000;

        // El monstruo atacante fue destruído.
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertEquals(puntosInicialesDeVida, jugador2.getPuntosDeVida());

        // El insecto come-hombres sigue vivo y jugador no perdió vida.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));
        Assert.assertEquals(puntosInicialesDeVida, jugador1.getPuntosDeVida());
    }

    @Test
    public void atacarATrampaCilindroMagico_seNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacante() {
        Monstruo monstruoAtacante = new PezDe7Colores(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);
        Carta cilindroMagico = new CilindroMagico(jugador1);

        jugador1.colocarCartaEnCampo((Carta) cilindroMagico, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // Las cartas monstruo de ambos lados del tablero siguen vivas.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoAtacante));

        // El que ataco recibió ataque a sus puntos de vida igual al ataque de la carta con la que atacó.
        Integer vidaFinalAtacante = 8000 - monstruoAtacante.getAtaque();
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El atacado no recibe daño alguno.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());

        // La carta Trampa se queda activa por este turno.
        Assert.assertTrue(cilindroMagico.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(cilindroMagico));

        // La carta Trampa después del turno de ser activada va al cementerio.
        turno.pasarTurno();
        Assert.assertFalse(cilindroMagico.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }


    @Test
    public void colocoTrampaRefuerzos_seAtacaConMonstruoDe200ATKMas_monstruoAtacadoAumenta500ATKAlActivarTrampa() {
        Trampa refuerzos = new Refuerzos(jugador1);
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Monstruo monstruoAtacante = new Jinzo7(jugador2); // ATK 500

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo((Carta) refuerzos, new BocaAbajo());
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaAbajo());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        // Al atacar al monstruoAtacado se activa la trampa, que le suma 500ATK a este mismo.
        monstruoAtacante.atacar(monstruoAtacado);

        // Muere el monstruo atacante.
        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoAtacante));

        Assert.assertTrue(monstruoAtacado.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));

        // Se le resta a los puntos de vida del atacante la diferencia de ataques.
        Integer vidaFinalAtacante = 8000 - ((300 + 500) - 500);
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El jugador atacado no recibe daño.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());

        // La carta Trampa se queda activa por este turno.
        Assert.assertTrue(refuerzos.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(refuerzos));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(refuerzos));

        // La carta Trampa después del turno de ser activada va al cementerio.
        turno.pasarTurno();
        Assert.assertFalse(refuerzos.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(refuerzos));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(refuerzos));
    }

    @Test
    public void extraerTodasLasCartasDeMazo_jugadorSinCartasPerdio() {
        Monstruo monstruo1 = new BebeDragon(jugador1);
        Monstruo monstruo2 = new Kuriboh(jugador1);

        jugador1.agregarCartaAMazo(monstruo1);
        jugador2.agregarCartaAMazo(monstruo2);

        // Con jugadores recién creados y cartas en los mazos la partida no terminó.
        Assert.assertFalse(juego.terminoPartida());
        Assert.assertEquals(null, juego.ganadorPartida());

        // Se toma la última carta que había (se debería de poder jugar el último turno).
        // Cuando se quiere empezar otro turno sin cartas en mazo se termina partida.
        jugador1.tomarCartaDelMazo();
        //jugador1.tomarCartaDelMazo(); aca lanza excepcion, porque sacar una carta del mazo sin cartas no es posible (falta turnos)

        // Al no tener más cartas en mazo se termina la partida y el jugador sin cartas pierde.
        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2, juego.ganadorPartida());
    }

    @Test
    public void colocarCincoPartesDeExodia_jugadorConPartesGanaPartido() {
        Monstruo parteExodia1 = new PiernaDerechaExodia(jugador1);
        Monstruo parteExodia2 = new PiernaIzquierdaExodia(jugador1);
        Monstruo parteExodia3 = new CabezaExodia(jugador1);
        Monstruo parteExodia4 = new BrazoDerechoExodia(jugador1);
        Monstruo parteExodia5 = new BrazoIzquierdoExodia(jugador1);

        jugador2.agregarCartaAMazo(new MagoOscuro(jugador2));
        jugador1.agregarCartaAMazo(new PezDe7Colores(jugador1));

        jugador1.agregarCartaAMazo(parteExodia1);
        jugador1.agregarCartaAMazo(parteExodia2);
        jugador1.agregarCartaAMazo(parteExodia3);
        jugador1.agregarCartaAMazo(parteExodia4);
        jugador1.agregarCartaAMazo(parteExodia5);

        for (int i = 0; i<5; i++) {
            jugador1.tomarCartaDelMazo();
        }

        // Cuando un jugador tiene las cinco partes en la mano, se termina la partida y este gana directamente.
        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador1, juego.ganadorPartida());
    }
}

