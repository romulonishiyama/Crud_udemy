package br.com.udemy.udemy.modelos;

import br.com.udemy.udemy.modelos.statusdopedido.StatusDoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StatusDoPedido statusDoPedido;
    private Date dataDoPedido = new Date();
    @OneToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;


    public Pedido(){}
    public Pedido(StatusDoPedido statusDoPedido, Date dataDoPedido) {
        this.statusDoPedido = statusDoPedido;
        this.dataDoPedido = dataDoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", statusDoPedido=" + statusDoPedido +
                ", dataDoPedido=" + dataDoPedido +
                '}';
    }
}
