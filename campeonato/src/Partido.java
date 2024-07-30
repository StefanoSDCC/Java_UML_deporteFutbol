import java.util.Date;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Date fecha;
    private Marcador marcador;
    private Estadio estadio;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Date fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.marcador = new Marcador();
    }

    public void actualizarMarcador(int golesLocal, int golesVisitante) {
        marcador.setGolesLocal(golesLocal);
        marcador.setGolesVisitante(golesVisitante);
    }

    public void finalizarPartido() {
        int golesLocal = marcador.getGolesLocal();
        int golesVisitante = marcador.getGolesVisitante();


        equipoLocal.setGolesAFavor(equipoLocal.getGolesAFavor() + golesLocal);
        equipoLocal.setGolesEnContra(equipoLocal.getGolesEnContra() + golesVisitante);
        equipoVisitante.setGolesAFavor(equipoVisitante.getGolesAFavor() + golesVisitante);
        equipoVisitante.setGolesEnContra(equipoVisitante.getGolesEnContra() + golesLocal);

        if (golesLocal > golesVisitante) {
            equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados() + 1);
            equipoVisitante.setPartidosPerdidos(equipoVisitante.getPartidosPerdidos() + 1);
        } else if (golesLocal < golesVisitante) {
            equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados() + 1);
            equipoLocal.setPartidosPerdidos(equipoLocal.getPartidosPerdidos() + 1);
        } else {
            equipoLocal.setPartidosEmpatados(equipoLocal.getPartidosEmpatados() + 1);
            equipoVisitante.setPartidosEmpatados(equipoVisitante.getPartidosEmpatados() + 1);
        }
    }

    public void mostrarResultado() {
        System.out.println(equipoLocal.getNombre() + " " + marcador.getGolesLocal() + " - " + marcador.getGolesVisitante() + " " + equipoVisitante.getNombre());
    }


    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
}


