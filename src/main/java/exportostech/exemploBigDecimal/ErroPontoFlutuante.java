package exportostech.exemploBigDecimal;

/**
 * Classe responsável por calcular e gerar um exemplo de calculo não preciso com pontos flutuantes.
 *
 * Exemplo de valor não preciso: Valor total é: 1.9999998
 */
public class ErroPontoFlutuante {

    public static void main(String[] args) {

        double valor = 0.2;
        double total = 0.0;

        for (int i = 0; i < 10; i++) {
            total += valor;
        }

        System.out.println("O valor total é igual a " + total);
    }
}
