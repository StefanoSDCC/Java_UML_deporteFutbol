import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campeonato {
    private String nombre;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;
    private float presupuesto;
    private List<Equipo> equipos;
    private Reglamento reglamento;
    private List<Partido> partidos;
    private TablaDePosiciones tablaDePosiciones;

    public Campeonato(String nombre, String tipo, Date fechaInicio, Date fechaFin, float presupuesto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.presupuesto = presupuesto;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.tablaDePosiciones = new TablaDePosiciones();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
        tablaDePosiciones.agregarEquipo(equipo);
    }

    public void definirReglamento(Reglamento reglamento) {
        this.reglamento = reglamento;
    }

    public void generarFixture() {
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                partidos.add(new Partido(equipos.get(i), equipos.get(j), new Date()));
            }
        }
    }

    public void iniciarCampeonato() {
        if (fechaInicio.after(new Date())) {
            System.out.println("El campeonato ha comenzado.");
            for (Partido partido : partidos) {

                System.out.println("Partido: " + partido.getEquipoLocal().getNombre() + " vs " + partido.getEquipoVisitante().getNombre());
            }
        } else {
            System.out.println("La fecha de inicio del campeonato ya ha pasado.");
        }
    }

    public void finalizarCampeonato() {
        if (fechaFin.before(new Date())) {
            System.out.println("El campeonato ha finalizado.");
            mostrarTabla();
        } else {
            System.out.println("El campeonato aún no ha terminado.");
        }
    }

    public void actualizarTabla(Partido partido) {
        tablaDePosiciones.actualizarTabla(partido);
    }

    public void mostrarTabla() {
        tablaDePosiciones.mostrarTabla();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Reglamento getReglamento() {
        return reglamento;
    }

    public void setReglamento(Reglamento reglamento) {
        this.reglamento = reglamento;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public TablaDePosiciones getTablaDePosiciones() {
        return tablaDePosiciones;
    }

    public void setTablaDePosiciones(TablaDePosiciones tablaDePosiciones) {
        this.tablaDePosiciones = tablaDePosiciones;
    }
}
