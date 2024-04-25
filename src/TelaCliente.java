import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

    TelaCarrinho carrinho;

    //BORDA
    private final int ESPESSURA = 10;
    private final Border borda = BorderFactory.createEmptyBorder(ESPESSURA,ESPESSURA,ESPESSURA,ESPESSURA);
    private final Dimension tamanhoJbutton = new Dimension(120,30);

    //PAINEIS
    protected JPanel pnlBotoes;
    protected JPanel pnlListaItens;

    //LISTA DE ITENS
    protected JLabel lblListaItens;
    protected JList<Produto> listaItens;

    //BOTÕES
    protected JButton btnComprar;
    protected JButton btnCarrinho;
    protected JButton btnVoltar;

    //CLIENTE
    Cliente cliente;

    public TelaCliente(Cliente user){
        cliente = user;
        inicializador();
        eventos();

    }

    private void inicializador(){
        this.setTitle("Cliente");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlBotoes(), BorderLayout.PAGE_END);
        this.getContentPane().add(getPnlListaItens(), BorderLayout.CENTER);

        this.setResizable(false);
        this.pack();

        this.setVisible(true);

    }

    private void btnComprarClick(ActionEvent evento){
        if(!listaItens.isSelectionEmpty())
            cliente.carrinho.addAll(listaItens.getSelectedValuesList());
    }

    private void btnCarrinhoClick(ActionEvent evento){
        if(carrinho == null)
            carrinho = new TelaCarrinho(this.cliente);
    }

    private void btnVoltarClick(ActionEvent evento){

        new TelaLogin();
        this.dispose();
        carrinho.dispose();
    }

    private void eventos(){
        btnComprar.addActionListener(this::btnComprarClick);
        btnCarrinho.addActionListener(this::btnCarrinhoClick);
        btnVoltar.addActionListener(this::btnVoltarClick);
    }

    private JPanel getPnlBotoes(){
        if (pnlBotoes == null){
            pnlBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnComprar = new JButton("Comprar");
            btnCarrinho = new JButton("Carrinho");
            btnVoltar = new JButton("Voltar");

            btnComprar.setPreferredSize(tamanhoJbutton);
            btnCarrinho.setPreferredSize(tamanhoJbutton);
            btnVoltar.setPreferredSize(tamanhoJbutton);

            pnlBotoes.add(btnVoltar);
            pnlBotoes.add(btnCarrinho);
            pnlBotoes.add(btnComprar);

            pnlBotoes.setBorder(borda);
        }

        return pnlBotoes;
    }


    private JPanel getPnlListaItens(){
        if(pnlListaItens == null){
            pnlListaItens = new JPanel(new GridLayout(2,1));

            lblListaItens = new JLabel("Itens a venda: ");
            listaItens = new JList<>(Loja.produtosCadatrado);

            pnlListaItens.add(lblListaItens);
            pnlListaItens.add(new JScrollPane(listaItens));

            pnlListaItens.setBorder(borda);
        }

        return pnlListaItens;
    }
}
