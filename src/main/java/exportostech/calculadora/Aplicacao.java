package exportostech.calculadora;

import javax.swing.*;

/**
 * Essa classe mantém um método responsavel por não travar a aplicação,
 * tambem chama nossa tela dentro de uma thread.
 * @author Guilherme.
 */
public class Aplicacao {

    public static void main(String[] args) {

        // metodo responsavel por nao travar a aplicação, chama a tela dentro de uma thread.
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}
