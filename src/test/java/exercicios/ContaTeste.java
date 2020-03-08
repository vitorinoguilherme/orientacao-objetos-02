package exercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTeste {
    private Conta conta;

    @BeforeEach
    public void beforeEach() {
        conta = new Conta(1, 1000.0);
    }

    @AfterEach
    public void afterEach() {
        conta = null;
    }

    @Test
    public void criarObjetoConta() {
        assertNotNull(conta);
    }

    @Test
    public void presencaAtributos() {
        assertNotNull(conta.getLimite());
        assertNotNull(conta.getNumero());
        assertNotNull(conta.getSaldo());
    }

    // Considerando Saldo inicial - 0.0
    @Test
    public void metodoGetSaldo() {
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    public void metodoSacarValorValido1() {
        conta.sacar(1.0);

        assertEquals(-1, conta.getSaldo());
    }

    @Test
    public void metodoSacarValorValido1000() {
        conta.sacar(1000.00);

        assertEquals(-1000.0, conta.getSaldo());
    }

    @Test
    public void metodoSacarValorInvalido1001() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.sacar(1001.0));
        assertEquals("Operação invalida, saldo insuficiente", exception.getMessage());
    }

    @Test
    public void metodoSacarValorInvalido1500() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.sacar(1500.0));
        assertEquals("Operação invalida, saldo insuficiente", exception.getMessage());
    }

    // Considerando valor limite inicial - 1000.0
    @Test
    public void metodoGetLimite() {
        assertEquals(1000.0, conta.getLimite());
    }

    @Test
    public void metodoSetLimiteValorValido1() {
        conta.setLimite(1.0);
        assertEquals(1.0, conta.getLimite());
    }

    @Test
    public void metodoSetLimiteValorValido1000() {
        conta.setLimite(1000.0);
        assertEquals(1000.0, conta.getLimite());
    }

    @Test
    public void metodoSetLimiteValorInvalido0() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.setLimite(0.0));
        assertEquals("Limite invalido", exception.getMessage());
    }

    @Test
    public void metodoSetLimiteValorInvalido1001() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.setLimite(1001.0));
        assertEquals("Limite invalido", exception.getMessage());
    }

    // Considerando saldo inicial - 0.0
    @Test
    public void metodoDepositoValorValido100() {
        conta.deposito(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    public void metodoDepositoValorInvalido0() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(0.0));
        assertEquals("Operação invalida.", exception.getMessage());
    }

    @Test
    public void metodoDepositoValorInvalidoNegativo100() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(-100.0));
        assertEquals("Operação invalida.", exception.getMessage());
    }

    // Transferencia da conta para conta1
    @Test
    public void metodoTransferirValorValido300() {
        Conta conta1 = new Conta(2, 1000.0);
        conta.deposito(500.0);

        conta.transferir(conta1, 300.00);

        assertEquals(200.0, conta.getSaldo());
        assertEquals(300.0, conta1.getSaldo());
    }

    @Test
    public void metodoTransferirValorInvalido501() {
        Conta conta1 = new Conta(2, 1000.0);
        conta.deposito(500.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> conta.transferir(conta1, 501.0));
        assertEquals("Operação invalida, saldo insuficiente", exception.getMessage());
    }

}
