package br.com.udemy.udemy.controles;

import br.com.udemy.udemy.modelos.Usuario;
import br.com.udemy.udemy.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro")
public class PaginaPrincipal {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public String paginaCadastrar(){
        return "cadastrar";
    }



    @PostMapping
    public String cadastrarUsuario( Usuario u){
        usuarioRepositorio.save(u);
        return "cadastrar";
    }


}
