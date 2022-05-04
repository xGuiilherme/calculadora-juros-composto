package exportostech.calculadora;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A classe <b>Calculadora</b> herda todos os comportamentos, métodos e atributos da classe <b>CalculadoraForm</b>.
 * a classe também implementa um tipo de método para fazer a conversão dos campos que temos em texto para aceitar os
 * valores de casas Decimal.
 *
 * HALF_EVEN representa o arredondamento do valor se a casa decimal for <= 0.4 arredonda para baixo e se for >= 0.6 ela
 * arredonda para cima e se for exatamente 0.5 ela sempre vai arrendondar para o número PAR mais proximo.
 *
 * Para evitar um erro caso o campo esteja vazio ou caso o valor seja inválido foi criado um método chamado toBigDecimal
 * que vai converter o conteúdo e caso acontece algum erro nessa conversão ele irá retornar um valor 0.
 *
 * @author Guilherme.
 */
public class Calculadora extends CalculadoraForm {

    /**
     * toBigDecimal: Método responsável para evitar um erro caso o campo esteja vazio ou inválido, ele vai converter
     * o conteúdo e caso acontece algum erro nessa conversão ele irá retornar um valor 0.
     * setScale: O valor 4 representa a quantidade de casas decimais.
     * @param valor String - Valores a ser convertido dos campos.
     * @return BigDecimal - Caso acontece algum erro na conversão dos valores ele irá retornar um valor 0.
     */
    private BigDecimal toBigDecimal(String valor) {
        try {
            return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN);
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }

    /**
     * btnCalcularClick: Método responsável para calcular e fazer as conversões dos valores de todos os campos.
     * Depois de fazer as conversões de todos os valores para BigDecimal é so efetuar os calculos.
     * taxaJuros.divide: É um número inteiro e eu preciso converter ela para um valor percentual ou seja dividir a taxa por 100.
     * BigDecimal.ONE: Faz a soma do número 1, uma vez que fez a soma do número 1 vai elevar a fração.
     * pow: Depois de somar o número 1 a taxa de juros, vai elevar a taxa de juros ao periodo.
     * periodo.intValue: Ele não faz nenhum tipo de arredondamento ele remove as casas decimais e mantem o valor inteiro.
     * multiply: Uma vez que eu fiz o meu montante eu vou multiplicar o meu montante pelo meu capital.
     * setScale: Vai setar o valor das casas decimais, nesse caso é 2 casas.
     * toPlainString: Vai converter os meus números em textos.
     *
     * @param ev Evento.
     */
    @Override
    protected void btnCalcularClick(ActionEvent ev) {

        // Faz a conversão dos valores para BigDecimal.
        BigDecimal capital = toBigDecimal(txtCapital.getText());
        BigDecimal taxaJuros = toBigDecimal(txtTaxaJuros.getText());
        BigDecimal periodo = toBigDecimal(txtPeriodo.getText());

        // Faz as conversões e calculos dos valores.
        BigDecimal montante = taxaJuros.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
        montante = montante.add(BigDecimal.ONE);
        montante = montante.pow(periodo.intValue());
        montante = montante.multiply(capital);
        montante = montante.setScale(2, RoundingMode.HALF_EVEN);

        // Resultado do calculo e converte o número em texto.
        txtMontante.setText(montante.toPlainString());
    }

    /**
     * btnLimparClick: Método responsável por remover qual coisa que esteja preenchido dentro de todos os campos.
     * @param ev Evento.
     */
    @Override
    protected void btnLimparClick(ActionEvent ev) {
        txtCapital.setText("");
        txtTaxaJuros.setText("");
        txtPeriodo.setText("");
        txtMontante.setText("");
    }

    /**
     * btnFecharClick: Método responsável por fechar a aplicação.
     * Para fechar a aplicação precisa setar ela como setVisible(false).
     * <b>setVisible</b> é o close e o <b>dispose</b> irá fechar a tela da aplicação.
     * @param ev Evento.
     */
    @Override
    protected void btnFecharClick(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
    }
}
