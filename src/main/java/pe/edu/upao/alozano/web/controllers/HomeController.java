package pe.edu.upao.alozano.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upao.alozano.web.overview.Usuario;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class HomeController {

    static ArrayList<Usuario> usuarioArrayList = new ArrayList();

    @GetMapping("/")
    String home() {
        return "Hello World!";
    }

    @PostMapping("/usuarios")
    private ArrayList<Usuario> crearUsuario(@RequestBody Usuario usuario) throws IOException {
        usuarioArrayList.add(usuario);
        return usuarioArrayList;
    }

    @GetMapping("/usuarios")
    private ArrayList<Usuario> listarUsuarios() {
        return usuarioArrayList;
    }
}
