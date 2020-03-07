package exercicios;

public class Circulo {
    private Double raio;

    public Circulo(Double raio) {
        if ( raio > 0 )
            this.raio = raio;
    }

    public Double calcularArea() {
        return Math.PI * raio * raio;
    }

    public Double calcularCircunferencia() {
        return 2 * Math.PI * raio;
    }

    public void setRaio(Double raio) throws IllegalAccessException {
        if ( raio <= 0 )
            throw new IllegalArgumentException("Valor deve ser maior que zero.");
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }
}
