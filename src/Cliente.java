import javax.swing.*;
import java.util.LinkedList;

public class Cliente extends Usuario{

    public final DefaultListModel<Produto> carrinho = new DefaultListModel<>();

    public Cliente(String nome, String senha, String cpf) {
        super(nome, senha, cpf);
    }
}
