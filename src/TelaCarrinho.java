import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class TelaCarrinho extends JFrame {

    //BORDA
    private final int ESPESSURA = 10;
    private final Border borda = BorderFactory.createEmptyBorder(ESPESSURA,ESPESSURA,ESPESSURA,ESPESSURA);
    private final Dimension tamanhoJbutton = new Dimension(120,30);

    //PAINEIS
    protected JPanel pnlBotoes;
    protected JPanel pnlListaCarrinho;

    //LISTA DE ITENS
    protected JLabel lblListaItens;
    protected JList<Produto> listaItens;

    //BOTÕES
    protected JButton btnComprar;
    protected JButton btnVoltar;

    //CLIENTE
    Cliente cliente;

    public TelaCarrinho(Cliente user){
        cliente = user;
        inicializador();
        eventos();
    }

    private void inicializador(){
        this.setTitle("Carrinho");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlBotoes(), BorderLayout.PAGE_END);
        this.getContentPane().add(getPnlListaCarrinho(), BorderLayout.CENTER);

        this.setResizable(false);
        this.pack();

        this.setVisible(true);
    }

    private void eventos(){
        btnComprar.addActionListener(this::btnComprarClick);
        btnVoltar.addActionListener(this::btnFecharClick);
    }

    private void btnComprarClick(ActionEvent evento){
        JOptionPane.showMessageDialog(null,"compra realizada com sucesso",
                "Compra concluida", JOptionPane.PLAIN_MESSAGE);

        cliente.carrinho.clear();
    }

    private void btnFecharClick(ActionEvent evento){
        this.dispose();
    }

    private JPanel getPnlBotoes(){
        if (pnlBotoes == null){
            pnlBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnComprar = new JButton("Comprar");
            btnVoltar = new JButton("Fechar");

            btnComprar.setPreferredSize(tamanhoJbutton);
            btnVoltar.setPreferredSize(tamanhoJbutton);

            pnlBotoes.add(btnVoltar);
            pnlBotoes.add(btnComprar);

            pnlBotoes.setBorder(borda);
        }

        return pnlBotoes;

    }

    private JPanel getPnlListaCarrinho(){
        if(pnlListaCarrinho == null){
            pnlListaCarrinho = new JPanel(new GridLayout(2,1));

            lblListaItens = new JLabel("Carrinho: ");

            listaItens = new JList<>(cliente.carrinho);

            pnlListaCarrinho.add(new JScrollPane(listaItens));

            pnlListaCarrinho.setBorder(borda);
        }

        return pnlListaCarrinho;
    }

}
