import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class AplicacaoTesouroDireto extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField campoJuros, campoAnos, campoDeposito;
    private JLabel lbJuros, lbAnos, lbDeposito, lbTotal, lbResultado;
    private JButton okBtn;

    private JMenuBar menuBar;
    private JMenuItem sobreMenuItem;

    private JButton limparBtn;

    public AplicacaoTesouroDireto() {
        super("Meu Tesouro Direto");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2));
        this.getContentPane().add(painel);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        sobreMenuItem = new JMenuItem("Ajuda");
        sobreMenuItem.addActionListener(this);
        menuBar.add(sobreMenuItem);
        
        lbJuros = new JLabel("Juros ao mês %:");
        campoJuros = new JTextField(15);
        painel.add(lbJuros);
        painel.add(campoJuros);
        lbAnos = new JLabel("Num. de anos:");
        campoAnos = new JTextField(15);
        painel.add(lbAnos);
        painel.add(campoAnos);
        lbDeposito = new JLabel("Depósito mensal R$:");
        campoDeposito = new JTextField(15);
        painel.add(lbDeposito);
        painel.add(campoDeposito);
        lbTotal = new JLabel("Total investido R$:");
        painel.add(lbTotal);
        lbResultado = new JLabel("");
        painel.add(lbResultado);
        painel.add(new JLabel());
        
        JPanel botaoPanel = new JPanel();
        botaoPanel.setLayout(new GridLayout(1, 2));
        
        okBtn = new JButton("OK");
        okBtn.addActionListener(this);
        botaoPanel.add(okBtn);
        
        limparBtn = new JButton("Limpar");
        limparBtn.addActionListener(this);
        botaoPanel.add(limparBtn);

        painel.add(botaoPanel);

    }

    /**
     * Método que implementa as ações do botão
     * 
     * @param evt
     * @return
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == okBtn) {
            double juros = Double.parseDouble(campoJuros.getText());
            int anos = Integer.parseInt(campoAnos.getText());
            double deposito = Double.parseDouble(campoDeposito.getText());
            TesouroDireto tesouro = new TesouroDireto(anos, juros, deposito);
            double resultado = tesouro.calculaTotal();
            
            DecimalFormat formatador = new DecimalFormat();
            formatador.setMaximumFractionDigits(2);
            lbResultado.setText(formatador.format(resultado));
        }

        if (evt.getSource() == sobreMenuItem) {
            String mensagem = "Meu Tesouro Direto - Calculadora de Investimento\n" +
                                 "Versão: 1.0\nAutor: JoyStreet\nData: 27/07/2020";
            JOptionPane.showMessageDialog(this, mensagem, "Sobre Meu Tesouro Direto", JOptionPane.DEFAULT_OPTION);
        }

        if (evt.getSource() == limparBtn) {
            campoJuros.setText("");;
            campoAnos.setText("");
            campoDeposito.setText("");
            lbResultado.setText("");
        }
    }

    public static void main(String args[]) {
        AplicacaoTesouroDireto janela = new AplicacaoTesouroDireto();
        janela.pack();
        janela.setVisible(true);
    }
}