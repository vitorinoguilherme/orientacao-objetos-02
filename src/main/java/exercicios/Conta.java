package exercicios;

public class Conta {
    private Integer numero;
    private Double saldo = 0.0;
    private Double limite = 1000.0;

    public Conta(Integer numero, Double limite) {
        if( (numero == null) | (limite < 0.0 ) && (limite > 1000.0) )
            throw new IllegalArgumentException("Campos invalidos");
        this.numero = numero;
        this.limite = limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void deposito( Double depositoMontante ) {
        if ( depositoMontante <= 0.0 )
            throw new IllegalArgumentException("Operação invalida.");
        this.saldo += depositoMontante;
    }

    public void sacar(Double valorSaque) {
        if ( valorSaque > (saldo + limite) )
            throw new IllegalArgumentException("Operação invalida, saldo insuficiente");
        this.saldo -= valorSaque;
    }

    public void transferir(Conta conta, Double valorTransferencia) {
        if ( valorTransferencia > saldo )
            throw new IllegalArgumentException("Operação invalida, saldo insuficiente");
        this.saldo -= valorTransferencia;
        conta.saldo += valorTransferencia;
    }

    public void setLimite(Double limite) {
        if( limite <= 0.0 || limite > 1000.0 )
            throw new IllegalArgumentException("Limite invalido");
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public Integer getNumero() {
        return numero;
    }
}
