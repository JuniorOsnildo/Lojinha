import java.util.LinkedList;

public class Usuario {
    private final String nome;
    private final String senha;
    private final String cpf;

    public static final LinkedList<Admistrador> listaAdministrador = new LinkedList<>();
    public static final LinkedList<Cliente> listaCliente = new LinkedList<>();

    public Usuario(String nome, String senha, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }

    public static Usuario validacao(String nome,String senha,String cpf){

        for (Cliente user:listaCliente) {
            if(user.getNome().equals(nome) && user.getSenha().equals(senha) && user.getCpf().equals(cpf)){
                return user;
            }
        }

        for (Usuario user:listaAdministrador) {
            if(user.getNome().equals(nome) && user.getSenha().equals(senha) && user.getCpf().equals(cpf)){
                return user;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }
}
