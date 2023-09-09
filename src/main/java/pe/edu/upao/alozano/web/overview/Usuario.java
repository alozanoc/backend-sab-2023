package pe.edu.upao.alozano.web.overview;

public class Usuario {
    private String nombre;
    private String username;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
