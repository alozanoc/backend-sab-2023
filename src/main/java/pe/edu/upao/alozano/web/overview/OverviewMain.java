package pe.edu.upao.alozano.web.overview;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class OverviewMain {
    static String authenticatedUsername = "anónimo";

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Usuario> usuarioArrayList = new ArrayList();

    public static void main(String[] args) throws IOException {
        String opc = "";
        do {
            System.out.println("Menu");
            System.out.println("-------------------");
            System.out.println("Bienvenido " + authenticatedUsername);
            System.out.println("-------------------");
            System.out.println("A. Crear usuario");
            System.out.println("B. Listar usuarios");
            System.out.println("C. Login");
            System.out.println("D. Cerrar Sesión");
            System.out.println("Z. Salir");

            System.out.print("Seleccione una opción: ");

            opc = br.readLine();
            switch (opc.toUpperCase()) {
                case "A" -> crearUsuario();
                case "B" -> listarUsuarios();
                case "C" -> autenticarUsuario();
                case "D" -> cerrarSesion();
                default -> System.out.println("Opción incorrecta");
            }
        } while (!opc.equalsIgnoreCase("Z"));

    }

    private static void autenticarUsuario() throws IOException {
        System.out.print("Ingrese su username: ");
        String username = br.readLine();

        System.out.print("Ingrese su password: ");
        String password = br.readLine();

        Optional<Usuario> result = usuarioArrayList.stream().filter(usuario -> {
            return usuario.getUsername().equalsIgnoreCase(username)
                    && usuario.getPassword().equals(password);
        }).findFirst();

        if (result.isPresent()) {
            System.out.println("Bienvenido" + result.get().getNombre());
            authenticatedUsername = result.get().getUsername();
        } else {
            System.out.println("Usuario y/o contraseña incorrecto");
        }
    }

    private static void cerrarSesion() {
        authenticatedUsername = "anónimo";
    }

    private static void crearUsuario() throws IOException {
        System.out.print("Ingrese su nombre: ");
        String nombre = br.readLine();

        System.out.print("Ingrese su username: ");
        String username = br.readLine();

        System.out.print("Ingrese su password: ");
        String password = br.readLine();

        Usuario usuario = new Usuario(nombre, username, password);

        usuarioArrayList.add(usuario);
    }

    private static void listarUsuarios() {
        usuarioArrayList.stream()
                .map(usuario -> usuario.getNombre().toUpperCase())
                .forEach(nombre -> {
                    System.out.println("-" + nombre);
                });
    }
}
