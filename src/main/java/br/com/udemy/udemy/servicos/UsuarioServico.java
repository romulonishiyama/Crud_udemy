package br.com.udemy.udemy.servicos;

import br.com.udemy.udemy.modelos.Usuario;
import br.com.udemy.udemy.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    //SELECIONAR USUARIOS
    public Iterable<Usuario> obterTodosUsuarios(){
        return usuarioRepositorio.findAll();
    }
    public ResponseEntity<?> obterUsuarioPorId(int id){
        return new ResponseEntity<>(usuarioRepositorio.findById(id), HttpStatus.OK);
    }

    //INSERIR USUARIO
    public ResponseEntity<?> inserirUsuario(Usuario usuario){

        return new ResponseEntity<>(usuarioRepositorio.save(usuario), HttpStatus.CREATED);
    }
    //ALTERAR USUARIO
    public ResponseEntity<?> alterarDadosDoUsuario(Usuario usuario){
        return new ResponseEntity<>(usuarioRepositorio.save(usuario), HttpStatus.ACCEPTED);
    }
    //DELETAR USUARIO
    public  ResponseEntity<?> deletarUsuarioPorId(int id){
        usuarioRepositorio.deleteById(id);
        String mensagem = "Deletado com sucesso!";
        return new ResponseEntity<>(mensagem, HttpStatus.ACCEPTED);
    }




}
