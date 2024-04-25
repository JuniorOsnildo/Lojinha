public class Main {
    public static void main(String[] args) {


        Cliente c = new Cliente("1","1","1");
        Usuario.listaCliente.add(c);
        Admistrador a = new Admistrador("a","1","1");
        Usuario.listaAdministrador.add(a);

        Loja loja = new Loja();
        new TelaLogin();

    }
}