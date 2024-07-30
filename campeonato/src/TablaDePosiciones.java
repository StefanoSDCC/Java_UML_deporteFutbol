import java.util.ArrayList;
import java.util.List;

public class TablaDePosiciones {
    private List<Posicion> posiciones;  // Relación: 1 a *

    public TablaDePosiciones() {
        this.posiciones = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        posiciones.add(new Posicion(equipo));
    }

    public void actualizarTabla(Partido partido) {
        Equipo equipoLocal = partido.getEquipoLocal();
        Equipo equipoVisitante = partido.getEquipoVisitante();
        int golesLocal = partido.getMarcador().getGolesLocal();
        int golesVisitante = partido.getMarcador().getGolesVisitante();

        Posicion posicionLocal = buscarPosicion(equipoLocal);
        Posicion posicionVisitante = buscarPosicion(equipoVisitante);

        posicionLocal.setPartidosJugados(posicionLocal.getPartidosJugados() + 1);
        posicionVisitante.setPartidosJugados(posicionVisitante.getPartidosJugados() + 1);

        posicionLocal.setGolesFavor(posicionLocal.getGolesFavor() + golesLocal);
        posicionVisitante.setGolesFavor(posicionVisitante.getGolesFavor() + golesVisitante);

        posicionLocal.setGolesContra(posicionLocal.getGolesContra() + golesVisitante);
        posicionVisitante.setGolesContra(posicionVisitante.getGolesContra() + golesLocal);

        if (golesLocal > golesVisitante) {
            posicionLocal.setPartidosGanados(posicionLocal.getPartidosGanados() + 1);
            posicionLocal.setPuntos(posicionLocal.getPuntos() + 3);
            posicionVisitante.setPartidosPerdidos(posicionVisitante.getPartidosPerdidos() + 1);
        } else if (golesLocal < golesVisitante) {
            posicionVisitante.setPartidosGanados(posicionVisitante.getPartidosGanados() + 1);
            posicionVisitante.setPuntos(posicionVisitante.getPuntos() + 3);
            posicionLocal.setPartidosPerdidos(posicionLocal.getPartidosPerdidos() + 1);
        } else {
            posicionLocal.setPartidosEmpatados(posicionLocal.getPartidosEmpatados() + 1);
            posicionVisitante.setPartidosEmpatados(posicionVisitante.getPartidosEmpatados() + 1);
            posicionLocal.setPuntos(posicionLocal.getPuntos() + 1);
            posicionVisitante.setPuntos(posicionVisitante.getPuntos() + 1);
        }

        posicionLocal.setDiferenciaGoles(posicionLocal.getGolesFavor() - posicionLocal.getGolesContra());
        posicionVisitante.setDiferenciaGoles(posicionVisitante.getGolesFavor() - posicionVisitante.getGolesContra());
    }

    private Posicion buscarPosicion(Equipo equipo) {
        for (Posicion posicion : posiciones) {
            if (posicion.getEquipo().equals(equipo)) {
                return posicion;
            }
        }
        return null;
    }

    public void mostrarTabla() {
        posiciones.sort((p1, p2) -> {
            int puntosComparison = Integer.compare(p2.getPuntos(), p1.getPuntos());
            if (puntosComparison != 0) {
                return puntosComparison;
            }
            return Integer.compare(p2.getDiferenciaGoles(), p1.getDiferenciaGoles());
        });

        for (Posicion pos : posiciones) {
            System.out.println(pos.getEquipo().getNombre() + " - " + pos.getPuntos() + " puntos, Diferencia de Goles: " + pos.getDiferenciaGoles());
        }
    }
}
