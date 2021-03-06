package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CincoOSeisEstrellasTest {

    private CincoASeisEstrellas cincoOSeisEstrellas;

    private Monstruo monstruo1;
    private Monstruo monstruo2;

    @Before
    public void setUp() {
        cincoOSeisEstrellas = CincoASeisEstrellas.getInstancia();
    }

    @Test
    public void requiere1Sacrificio() {
        Integer sacrificiosRequeridos = 1;

        Assert.assertEquals(sacrificiosRequeridos, cincoOSeisEstrellas.sacrificiosRequeridos());
    }

    @Test
    public void sacrificiosSuficientes_menosDe1SacrificioDevuelveFalse() {
        Monstruo[] monstruos = {};

        Assert.assertFalse(cincoOSeisEstrellas.sacrificiosSuficientes(monstruos));
    }

    @Test
    public void sacrificiosSuficientes_exactamente1SacrificioDevuelveTrue() {
        Monstruo[] monstruos = {monstruo1};

        Assert.assertTrue(cincoOSeisEstrellas.sacrificiosSuficientes(monstruos));
    }

    @Test
    public void sacrificiosSuficientes_masDe1SacrificioDevuelveFalse() {
        Monstruo[] monstruos = {monstruo1, monstruo2};

        Assert.assertFalse(cincoOSeisEstrellas.sacrificiosSuficientes(monstruos));
    }
}
