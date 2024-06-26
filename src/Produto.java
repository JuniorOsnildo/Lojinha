public class Produto {

    private final String nome;
    private final float preco;

    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format(this.nome + " - R$ %.2f", this.preco);
    }
}
