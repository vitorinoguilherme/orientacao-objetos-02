package exercicios;

public class Correntista {
    private String codigo;
    private String nome;
    private String email;
    private Integer tel;
    private Double saldo = 0.0;

    public Correntista(String codigo, String nome, String email, Integer tel) {
        if ( (codigo == null) | (nome == null) | ( email == null ) | ( tel <= 0 ) )
            throw new IllegalArgumentException(
                    "Operação invalida, algum campo do registro não confere. ");
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
        this.tel = tel;
    }

    public void deposito(Double depositoMontante ) {
        if ( depositoMontante <= 0.0 )
            throw new IllegalArgumentException("Operação invalida.");
        this.saldo += depositoMontante;
    }

    public void sacar(Double valorSaque) {
        if ( valorSaque > saldo )
            throw new IllegalArgumentException("Operação invalida, saldo insuficiente");
        this.saldo -= valorSaque;
    }

    // c1 - conta 1
    public void transferir(Correntista c1, Double valorTransferencia) {
        if ( valorTransferencia > saldo )
            throw new IllegalArgumentException("Operação invalida, saldo insuficiente");
        this.saldo -= valorTransferencia;
        c1.saldo += valorTransferencia;
    }

    public void setCodigo(String codigo) {
        if ( codigo == null )
            throw new IllegalArgumentException("Informe o código da conta.");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        if ( nome == null )
            throw new IllegalArgumentException("Informe o nome da conta.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        if ( email == null )
            throw new IllegalArgumentException("Informe o e-mail da conta.");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTel(Integer tel) {
        if ( tel <= 0 )
            throw new IllegalArgumentException("Telefone invalido, digite novamente.");
        this.tel = tel;
    }

    public int getTel() {
        return tel;
    }

    public Double getSaldo() {
        return saldo;
    }
}
