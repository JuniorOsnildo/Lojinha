import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class TelaLogin extends JFrame {

    //Bordas
    private final int ESPESSURA = 10;
    private final Border borda = BorderFactory.createEmptyBorder(ESPESSURA,ESPESSURA,ESPESSURA,ESPESSURA);
    private final Dimension tamanhoJbutton = new Dimension(120,30);


    //Paineis
    protected JPanel pnlLogin;
    protected JPanel pnlRodape;

    //CPF
    protected JLabel lblCpf;
    protected JTextField txtCpf;

    //USUARIO
    protected JLabel lblUsuario;
    protected JTextField txtUsuario;

    //SENHA
    protected JLabel lblSenha;
    protected JTextField txtSenha;

    //BOTÕES
    protected JButton btnOk;
    protected JButton btnFechar;
    protected JButton btnCriarConta;

    public TelaLogin() {
        this.inicializar();
        this.eventos();
    }

    private void inicializar(){
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlLogin(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    private void eventos(){
        btnOk.addActionListener(this::btnOkClick);
        btnFechar.addActionListener(this::btnFecharClick);
        btnCriarConta.addActionListener(this::btnCriarContaClick);
    }

    private void btnFecharClick(ActionEvent click){
        this.dispose();
    }

    private void btnOkClick(ActionEvent click){

        Usuario user = Usuario.validacao(txtUsuario.getText(),txtSenha.getText(),txtCpf.getText());

        if(user != null){
            if(user instanceof Admistrador){
                new TelaAdm();


            } else if (user instanceof Cliente userCli){
                new TelaCliente(userCli);

            }
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null,"Senha ou Usuario invalido",
                    "Valores invalidos",WARNING_MESSAGE);

            txtUsuario.setText("");
            txtSenha.setText("");
            txtCpf.setText("");
        }
    }

    private void btnCriarContaClick(ActionEvent click){
        new TelaCriarConta();
        this.dispose();
    }


    private JPanel getPnlRodape(){
        if (pnlRodape == null){
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnFechar = new JButton("Fechar");
            btnOk = new JButton("Ok");
            btnCriarConta = new JButton("Criar conta");

            btnFechar.setPreferredSize(tamanhoJbutton);
            btnOk.setPreferredSize(tamanhoJbutton);
            btnCriarConta.setPreferredSize(tamanhoJbutton);


            pnlRodape.add(btnFechar);
            pnlRodape.add(btnCriarConta);
            pnlRodape.add(btnOk);

            pnlRodape.setBorder(borda);
        }

        return pnlRodape;
    }

    private JPanel getPnlLogin(){
        if (pnlLogin == null){
            pnlLogin = new JPanel(new GridLayout(3,2,5,5));

            lblUsuario = new JLabel("Usuarios");
            txtUsuario = new JTextField(10);

            lblSenha = new JLabel("Senha");
            txtSenha = new JTextField(10);

            lblCpf = new JLabel("CPF");
            txtCpf = new JTextField(10);

            pnlLogin.add(lblUsuario);
            pnlLogin.add(txtUsuario);

            pnlLogin.add(lblSenha);
            pnlLogin.add(txtSenha);

            pnlLogin.add(lblCpf);
            pnlLogin.add(txtCpf);

            pnlLogin.setBorder(borda);
        }

        return pnlLogin;
    }
}
