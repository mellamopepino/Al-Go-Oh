package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EstadoCarta;

import java.util.List;

public interface EstadoEnTurno {

    EstadoEnTurno verificarQueSePuedeUsar();

    EstadoEnTurno pasarTurno();

    List<AccionCarta> accionesCartaDisponibles(Monstruo carta, EstadoCarta estadoCarta);

    List<AccionCarta> accionesCartaDisponibles(Magica carta, EstadoCarta estadoCarta);

    List<AccionCarta> accionesCartaDisponibles(Trampa carta, EstadoCarta estadoCarta);

    List<AccionCarta> accionesCartaDisponibles(CartaCampo carta, EstadoCarta estadoCarta);


}
