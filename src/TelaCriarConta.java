import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class TelaCriarConta extends JFrame {

    //Bordas
    private final int ESPESSURA = 10;
    private final Border borda = BorderFactory.createEmptyBorder(ESPESSURA,ESPESSURA,ESPESSURA,ESPESSURA);
    private final Dimension tamanhoJbutton = new Dimension(120,30);

    //CPF
    protected JLabel lblCpf;
    protected JTextField txtCpf;

    //USUARIO
    protected JLabel lblUsuario;
    protected JTextField txtUsuario;

    //SENHA
    protected JLabel lblSenha;
    protected JTextField txtSenha;

    //CHECKBOX
    protected ButtonGroup grupoCheck = new ButtonGroup();
    protected JCheckBox chbAdimin;
    protected JCheckBox chbCliente;
    protected JCheckBox chbNone;

    //PAINEIS
    protected JPanel pnlCampos;
    protected JPanel pnlRodape;

    //BOTOES
    protected JButton btnCriar;
    protected JButton btnVoltar;

    public TelaCriarConta(){
        inicializador();
        eventos();
    }

    private void inicializador(){
        this.setTitle("Criar conta");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlCampos(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void eventos(){
        btnCriar.addActionListener(this::btnCriarContaClick);
        btnVoltar.addActionListener(this::btnVoltarClick);
    }

    private void btnVoltarClick(ActionEvent click){
        new TelaLogin();
        this.dispose();
    }

    private void btnCriarContaClick(ActionEvent click){

        if((txtUsuario.getText().equals("") || txtSenha.getText().equals("") || txtCpf.getText().equals("")) ||
                !(chbAdimin.isSelected() || chbCliente.isSelected())){

            JOptionPane.showMessageDialog(null,
                    "É Necessário preecher todos os campos para prosseguir",
                    "Valores invalidos",WARNING_MESSAGE);

            txtUsuario.setText("");
            txtSenha.setText("");
            txtCpf.setText("");

        } else if (Usuario.validacao(txtUsuario.getText(),txtSenha.getText(),txtCpf.getText()) != null) {

            JOptionPane.showMessageDialog(null,
                    "Esse nomes de usuario e cpf ja esta sendo usado",
                    "Valores invalidos",WARNING_MESSAGE);

            txtUsuario.setText("");
            txtSenha.setText("");
            txtCpf.setText("");

        } else {


            if(chbCliente.isSelected()) {
                Cliente newUser = new Cliente(txtUsuario.getText(),txtSenha.getText(),txtCpf.getText());
                Usuario.listaCliente.add(newUser);
            }
            if(chbAdimin.isSelected()) {
                Admistrador newUser = new Admistrador(txtUsuario.getText(),txtSenha.getText(),txtCpf.getText());
                Usuario.listaAdministrador.add(newUser);
            }

            new TelaLogin();
            this.dispose();
        }


    }

    private JPanel getPnlCampos() {
        if (pnlCampos == null) {
            pnlCampos = new JPanel(new GridLayout(4, 2, 5, 5));

            lblUsuario = new JLabel("Usuarios");
            txtUsuario = new JTextField(10);

            lblSenha = new JLabel("Senha");
            txtSenha = new JTextField(10);

            lblCpf = new JLabel("CPF");
            txtCpf = new JTextField(10);

            chbAdimin = new JCheckBox("Adinistrador");
            chbCliente = new JCheckBox("Cliente");
            chbNone = new JCheckBox();

            chbNone.setSelected(true);

            grupoCheck.add(chbAdimin);
            grupoCheck.add(chbCliente);
            grupoCheck.add(chbNone);

            pnlCampos.add(lblUsuario);
            pnlCampos.add(txtUsuario);

            pnlCampos.add(lblSenha);
            pnlCampos.add(txtSenha);

            pnlCampos.add(lblCpf);
            pnlCampos.add(txtCpf);

            pnlCampos.add(chbAdimin);
            pnlCampos.add(chbCliente);

            pnlCampos.setBorder(borda);
        }

        return pnlCampos;
    }

    private JPanel getPnlRodape(){
        if (pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnVoltar = new JButton("Voltar");
            btnCriar = new JButton("Criar");

            btnVoltar.setPreferredSize(tamanhoJbutton);
            btnCriar.setPreferredSize(tamanhoJbutton);

            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnCriar);

            pnlRodape.setBorder(borda);
        }

        return pnlRodape;
    }

}
