public class EstadisticasJugador {
    private int goles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int minutosJugados;

    public EstadisticasJugador() {
        this.goles = 0;
        this.asistencias = 0;
        this.tarjetasAmarillas = 0;
        this.tarjetasRojas = 0;
        this.minutosJugados = 0;
    }

    public void actualizarEstadisticas(int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas, int minutosJugados) {
        this.goles += goles;
        this.asistencias += asistencias;
        this.tarjetasAmarillas += tarjetasAmarillas;
        this.tarjetasRojas += tarjetasRojas;
        this.minutosJugados += minutosJugados;
    }


}
