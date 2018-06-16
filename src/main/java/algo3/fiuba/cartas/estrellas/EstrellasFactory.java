package algo3.fiuba.cartas.estrellas;

public class EstrellasFactory {

    private EstrellasFactory() {
        // No tiene constructor
    }

    public static Estrellas obtenerEstrellas(Integer cantidadDeEstrellas) {
        if (cantidadDeEstrellas < 0)
            throw new RuntimeException("No puede tener estrellas negativas"); // !!!
        if (cantidadDeEstrellas <= 4)
            return UnaACuatroEstrellas.getInstancia();
        if (cantidadDeEstrellas == 5 || cantidadDeEstrellas == 6)
            return CincoOSeisEstrellas.getInstancia();

        return MasDe7Estrellas.getInstancia();
    }
}