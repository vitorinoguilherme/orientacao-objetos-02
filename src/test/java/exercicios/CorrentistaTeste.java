package exercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorrentistaTeste {
    private Correntista c1;

    @BeforeEach
    public void beforeEach() {
        c1 = new Correntista(
                "#", "Guilherme", "gui@gmail.com",
                1128755826);
    }

    @AfterEach
    public void afterEach() {
        c1 = null;
    }

    @Test
    public void criarObjetoCorrentista() {
        assertNotNull(c1);
    }

    @Test
    public void presencaAtributos() {
        assertNotNull(c1.getCodigo());
        assertNotNull(c1.getNome());
        assertNotNull(c1.getEmail());
        assertNotNull(c1.getTel());
    }

    // Saldo inicial = 0.0
    @Test
    public void metodoDepositoValor() {
        c1.deposito(200.0);

        assertEquals(200.0, c1.getSaldo());
    }

    // Saldo inicial = 0.0
    @Test
    public void metodoSaque() {
        c1.deposito(200.0);
        c1.sacar(150.0);

        assertEquals(50.0, c1.getSaldo());
    }

    // Valores validos
    @Test
    public void metodoSetValoresValidos() {
        c1.setCodigo("*");
        c1.setNome("nomeTeste");
        c1.setEmail("emailTeste@gmail.com");
        c1.setTel(1111111111);

        assertEquals("*", c1.getCodigo());
        assertEquals("nomeTeste", c1.getNome());
        assertEquals("emailTeste@gmail.com", c1.getEmail());
        assertEquals(1111111111, c1.getTel());
    }

    // Valores invalidos null e 0
    @Test
    public void metodoSetValoresInvalidos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> c1.setCodigo(null));
        assertEquals("Informe o código da conta.", exception.getMessage());

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> c1.setNome(null));
        assertEquals("Informe o nome da conta.", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> c1.setEmail(null));
        assertEquals("Informe o e-mail da conta.", exception2.getMessage());

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> c1.setTel(0));
        assertEquals("Telefone invalido, digite novamente.", exception3.getMessage());
    }

    // Objeto c1 tem como atributos "#", "Guilherme", "gui@gmail.com" 1128755826
    @Test
    public void metodosGetValoresValidos() throws IllegalAccessException {
        assertEquals("#", c1.getCodigo());
        assertEquals("Guilherme", c1.getNome());
        assertEquals("gui@gmail.com", c1.getEmail());
        assertEquals(1128755826, c1.getTel());
    }

}
