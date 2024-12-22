package javamysql;

public class ModeloDatos {
    private Integer id;
    private String nombre;
    private Integer edad;
    private String servicio;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getServicio() {
        return servicio;
    }

   
}
