package br.com.udemy.udemy.repositorios;

import br.com.udemy.udemy.modelos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
