import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository repository = new CadastroRepository();
        List<Cadastro> cadastros = repository.listar();

        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro.getId() + " " + cadastro.getNome());
        }
    }
}
