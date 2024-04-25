import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class TelaAdm extends JFrame {

    //BORDA
    private final int ESPESSURA = 10;
    private final Border borda = BorderFactory.createEmptyBorder(ESPESSURA,ESPESSURA,ESPESSURA,ESPESSURA);
    private final Dimension tamanhoJbutton = new Dimension(120,30);

    //LISTA
    protected JScrollPane barrinha;
    protected JList<Produto> listaItens;

    //Paineis
    protected JPanel pnlCadastro;
    protected JPanel pnlRodape;
    protected JPanel pnlList;

    //CPF
    protected JLabel lblNome;
    protected JTextField txtNome;

    //SENHA
    protected JLabel lblPreco;
    protected JTextField txtPreco;

    //BOTÕES
    protected JButton btnOk;
    protected JButton btnFechar;

    public TelaAdm() {
        this.inicializar();
        this.eventos();
    }

    private void inicializar(){
        this.setTitle("Administrador");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlCadastro(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.getContentPane().add(getPnlList(), BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
    }

    private void eventos() {
        btnOk.addActionListener(this::btnOkClick);
        btnFechar.addActionListener(this::btnFecharClick);
    }

    private void btnOkClick(ActionEvent click){

        if(txtNome.getText().equals("") || txtPreco.getText().equals("")){

            JOptionPane.showMessageDialog(null,
                    "É Necessário preecher todos os campos para prosseguir",
                    "Valores invalidos",WARNING_MESSAGE);


        }else {
            Loja.produtosCadatrado.addElement(new Produto(txtNome.getText(), Float.parseFloat(txtPreco.getText())));
        }

        txtNome.setText("");
        txtPreco.setText("");
    }

    private void btnFecharClick(ActionEvent click){
        new TelaLogin();
        this.dispose();
    }

    private JPanel getPnlRodape(){
        if (pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnFechar = new JButton("Fechar");
            btnOk = new JButton("Ok");

            btnFechar.setPreferredSize(tamanhoJbutton);
            btnOk.setPreferredSize(tamanhoJbutton);


            pnlRodape.add(btnFechar);
            pnlRodape.add(btnOk);

            pnlRodape.setBorder(borda);
        }

        return pnlRodape;
    }

    private JPanel getPnlCadastro(){
        if (pnlCadastro == null){
            pnlCadastro = new JPanel(new GridLayout(4,1,5,5));

            lblPreco = new JLabel("Preco");
            txtPreco = new JTextField(10);

            lblNome = new JLabel("Nome");
            txtNome = new JTextField(10);

            pnlCadastro.add(lblNome);
            pnlCadastro.add(txtNome);

            pnlCadastro.add(lblPreco);
            pnlCadastro.add(txtPreco);

            pnlCadastro.setBorder(borda);
        }

        return pnlCadastro;
    }

    private JPanel getPnlList() {
        if(pnlList == null){
            pnlList = new JPanel(new FlowLayout(FlowLayout.CENTER));

            listaItens = new JList<>(Loja.produtosCadatrado);

            barrinha = new JScrollPane(listaItens);

            pnlList.add(barrinha);

        }
        return pnlList;
    }

}
