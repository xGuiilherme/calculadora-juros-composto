package exportostech.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A classe <b>CalculadoraForm</b> define um tipo de dado abstrato para a criação da estrutura de uma Calculadora
 * de juros onde serão contidos, valores e métodos para o mesmo.
 * Para essa classe ser uma tela do tipo Java Swing precisamos extender uma outra classe do tipo JFrame, onde serão
 * implementados as constantes da janela de interface, assim como FlowLayout, BorderLayout e GridLayout.
 *
 * @author Guilherme.
 */
public abstract class CalculadoraForm extends JFrame {

    /**
     * Foi criado uma constante para centralizar os valor em um local unico e identificar de forma facil para que serve aquele numero.
     */
    private static final int TAMANHO_TXT = 10;

    /**
     * JPanel: É a onde vai ser definido o LayoutManager.
     * pnlForm: Formulario
     * pnlRodape: Rodapé do Layout.
     */
    protected JPanel pnlForm;
    protected JPanel pnlRodape;

    /**
     * JButton: Será criado 3 botões dentro do Layout no rodapé, onde sera realizado as ações da calculadora
     * calcular, limpar e fechar a janela.
     */
    protected JButton btnCalcular;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    /**
     * Para cada campo que for colocar na tela irá precisar de um Label e TextField onde será mostrado na tela.
     * JLabel: Nome do campo.
     * JTextField: Campo que sera digitado o valor (caixa de texto).
     */
    protected JLabel lblCapital;
    protected JTextField txtCapital;
    protected JLabel lblTaxaJuros;
    protected JTextField txtTaxaJuros;
    protected JLabel lblPeriodo;
    protected JTextField txtPeriodo;
    protected JLabel lblMontante;
    protected JTextField txtMontante;

    /**
     * CalculadoraForm: Construtor responsável por chamar o método inicializar e eventos.
     */
    public CalculadoraForm() {

        this.inicializar();
        this.eventos();
    }

    /**
     * inicializar: Método responsável por fazer a inicialização dos componentes da tela.
     * Nosso formulário principal foi usado o BorderLayout ele divide a tela em 4 partes sendo
     * centro, esquerda, direita, topo e rodapé.
     * A tela principal da aplicação eu chamo ela de <b>ContentPane</b> o setLayout(new BorderLayout()); esse layout já
     * fala pro meu formulário como que será distribuidos os componentes dentro do painel.
     */
    private void inicializar() {

        this.setTitle("Calculadora Juros Composto");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);

        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.pack();
    }

    /**
     * Método abstrato responsável por implementar as açoẽs do evento.
     *
     * @param ev Evento.
     */
    protected abstract void btnCalcularClick(ActionEvent ev);

    protected abstract void btnLimparClick(ActionEvent ev);

    protected abstract void btnFecharClick(ActionEvent ev);

    /**
     * Eventos: Método responsável por chamar a implementação dos campos CalcularClick, LimparClick e FecharClick, onde
     * será executado os eventos nos botões quando forem clicados.
     */
    private void eventos() {

        btnCalcular.addActionListener(this::btnCalcularClick);
        btnLimpar.addActionListener(this::btnLimparClick);
        btnFechar.addActionListener(this::btnFecharClick);
    }

    /**
     * PnlForm: Método get que irá fazer a verificação do <b>formulário</b> se os campos e as caixas de texto para digitação
     * dentro do layout foi criado ou não.
     * Se caso ele for nulo significa que precisa ser criado os painel e os campos para cada elementos.
     * O gerenciador de layout que foi utilizado nesse formulário foi o GridLayout: Ele distribui os campos de forma igual
     * dentro da tela no formato de uma tabela, definindo os rows: 4 linhas e cols: 2 colunas.
     * O campo Hgap e Vgap define as lacunas/folga entre os componentes.
     * @return Retorna o formulário com todos os campos criados dentro do painel com as linhas e colunas definidas no layout.
     */
    public JPanel getPnlForm() {

        if (pnlForm == null) {

            pnlForm = new JPanel(new GridLayout(4, 2, 5, 5));
            pnlForm.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            lblCapital = new JLabel("Capital");
            txtCapital = new JTextField(TAMANHO_TXT);

            lblTaxaJuros = new JLabel("Taxa Juros");
            txtTaxaJuros = new JTextField(TAMANHO_TXT);

            lblPeriodo = new JLabel("Periodo");
            txtPeriodo = new JTextField(TAMANHO_TXT);

            lblMontante = new JLabel("Montante");
            txtMontante = new JTextField(TAMANHO_TXT);
            txtMontante.setEditable(false);

            pnlForm.add(lblCapital);
            pnlForm.add(txtCapital);

            pnlForm.add(lblTaxaJuros);
            pnlForm.add(txtTaxaJuros);

            pnlForm.add(lblPeriodo);
            pnlForm.add(txtPeriodo);

            pnlForm.add(lblMontante);
            pnlForm.add(txtMontante);

        }
        return pnlForm;
    }

    /**
     * Método get que irá fazer a verificação do <b>rodapé</b> se os campos dentro do painel foi criado ou não.
     * Se caso ele for nulo significa que precisa ser criado e adicionado os botões dentro do painel com as ações.
     * O Gerenciador de layout colocamos ele dentro do construtor do painel JPanel(new FlowLayout(FlowLayout.CENTER));
     * Dentro do FlowLayout: Precisa dizer qual será o alinhamento dos botões se é para esquedar, centro ou direita.
     * @return Retorna o painel dentro do layout com os 3 botoẽs criados no rodapé.
     */
    public JPanel getPnlRodape() {

        if (pnlRodape == null) {

            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCalcular = new JButton("Calcular");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnCalcular);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }
}