public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository repository = new CadastroRepository();
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Maria Julia");
        cadastro.setIdade(15);

        repository.salvar(cadastro);
    }
}
