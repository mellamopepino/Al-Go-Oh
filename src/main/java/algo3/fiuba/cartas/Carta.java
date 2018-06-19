package algo3.fiuba.cartas;

import algo3.fiuba.*;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.*;

import java.util.Objects;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new EstadoNoInicializado();
        this.efecto = efecto;
    }

    public abstract void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... monstruos);

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
    }

    public boolean estaEnJuego() {
        return estadoCarta.estaEnJuego();
    }

    public void descartar() {
        jugador.mandarCartaACementerio(this);
        estadoCarta = EnCementerio.getInstancia();
    }

    public void setEstado(EstadoCarta estadoCarta) {
        this.estadoCarta = estadoCarta;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(nombre, carta.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }
    public void activar(Juego juego) {
        estadoCarta.activar(juego, this,  efecto);
    }

    public abstract boolean estaEnTablero(TableroJugador tableroJugador);

    //public abstract boolean esSacrificable();

    public abstract void removerDelCampo(Campo campo);


    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", estadoCarta=" + estadoCarta +
                ", efecto=" + efecto +
                '}';
    }

    public void colocarEnMano() {
        estadoCarta = EnMano.getInstancia();
    }

    public void aumentarATKPropio(int aumento) {
        jugador.aumentarATK(aumento);
    }

    public void aumentarDEFOponente(int aumento) {
        jugador.aumentarDEFOponente(aumento);
    }

    public void aumentarDEFPropio(int aumento) {
        jugador.aumentarDEF(aumento);
    }

    public void aumentarATKOponente(int aumento) {
        jugador.aumentarATKOponente(aumento);
    }
}
