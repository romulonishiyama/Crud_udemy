package br.com.udemy.udemy.modelos.statusdopedido;

public enum StatusDoPedido {
    AGUARDANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

    private int valorId;

    private StatusDoPedido(int id){
        valorId = id;
    }
    public int obterId(){
        return valorId;
    }


}
