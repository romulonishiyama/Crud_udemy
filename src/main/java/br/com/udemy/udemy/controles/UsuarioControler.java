package br.com.udemy.udemy.controles;

import br.com.udemy.udemy.modelos.Usuario;
import br.com.udemy.udemy.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioServico usuarioServico;


    //GET
    @GetMapping
    @ResponseBody
    public Iterable<Usuario> obterTodosUsuarios(){
        return usuarioServico.obterTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterUsuarioPorId(@PathVariable int id){
        return usuarioServico.obterUsuarioPorId(id);
    }


    @GetMapping("/busca")
    public ResponseEntity<?> obterUsuarioPorId2(@RequestParam(name = "id") int id){
        return usuarioServico.obterUsuarioPorId(id);
    }
    @GetMapping("/lista")
    public String lisarUsuarios(Model model){

        model.addAttribute("lista", usuarioServico.obterTodosUsuarios());

        return "listagem";

    }

    //POST
    @PostMapping
    public ResponseEntity<?> inserirUsuario(Usuario usuario){
        System.out.println(usuario);

        return  usuarioServico.inserirUsuario(usuario);
    }

    //PUT
    @PutMapping
    public ResponseEntity<?> alterarDadosDoUsuario(Usuario usuario){
        return usuarioServico.alterarDadosDoUsuario(usuario);
    }

    //DELETE
    @DeleteMapping
    public String ddeletarUsuarioPorId(@RequestParam(name = "id") int id){
        usuarioServico.deletarUsuarioPorId(id);
        return "redirect:/usuarios/lista";
    }

}

