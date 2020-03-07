package exercicios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CirculoTeste {
    private Circulo c1;

    @BeforeEach
    public void beforeEach() {
        c1 = new Circulo(3.0);
    }

    @AfterEach
    public void afterEach() {
        c1 = null;
    }

    @Test
    public void criarObjetoCirculo() {
        assertNotNull(c1);
    }

    @Test
    public void presencaAtributos() {
        assertNotNull(c1.getRaio());
    }

    @Test
    public void metodoCalcularArea() {
        assertEquals(28.274333882308138, c1.calcularArea());
    }

    @Test
    public void metodoCalcularCircunferencia() {
        assertEquals(18.84955592153876, c1.calcularCircunferencia());
    }

    // Valor raio valido 4
    @Test
    public void metodoSetRaioValorValido4() throws IllegalAccessException {
        c1.setRaio(4.0);

        assertEquals(4.0, c1.getRaio());
    }

    // Valor raio invalido 0
    @Test
    public void metodoSetRaioValorInvalido0() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> c1.setRaio(0.0));
        assertEquals("Valor deve ser maior que zero.", exception.getMessage());
    }

    // Valor raio invalido -4
    @Test
    public void metodoSetRaioValorInvalido4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> c1.setRaio(-4.0));
        assertEquals("Valor deve ser maior que zero.", exception.getMessage());
    }

    // Valor do raio = 3
    @Test
    public void metodoGetRaio() {
        assertEquals(3.0, c1.getRaio());
    }

}
