import java.util.ArrayList;
import java.util.List;

public class Reglamento {
    private String descripcion;
    private List<String> reglas;

    public Reglamento(String descripcion) {
        this.descripcion = descripcion;
        this.reglas = new ArrayList<>();
    }

    public void agregarRegla(String regla) {
        reglas.add(regla);
    }

    public void mostrarReglas() {
        for (String regla : reglas) {
            System.out.println(regla);
        }
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getReglas() {
        return reglas;
    }

    public void setReglas(List<String> reglas) {
        this.reglas = reglas;
    }
}

