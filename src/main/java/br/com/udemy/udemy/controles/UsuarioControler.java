package br.com.udemy.udemy.controles;

import br.com.udemy.udemy.modelos.Usuario;
import br.com.udemy.udemy.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioServico usuarioServico;


    //GET
    @GetMapping
    public ResponseEntity<?> obterTodosUsuarios(){
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
    public ResponseEntity<?> ddeletarUsuarioPorId(@RequestParam(name = "id") int id){
        return usuarioServico.deletarUsuarioPorId(id);
    }

}

