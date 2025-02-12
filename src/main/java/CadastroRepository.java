import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository() {
        conexao = FabricaConexao.getConexao();
    }

    public void incluir(Cadastro cadastro) {
        try {
            String sql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?,?);";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());

            pst.execute();

            System.out.println("Cadastro efetuado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro) {
        try {
            String sql = "UPDATE public.tab_cadastro SET nome = ?, idade = ? WHERE id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluir(Integer id) {
        try {
            String sql = "DELETE FROM public.tab_cadastro WHERE id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Cadastro> listar() {
        List<Cadastro> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM public.tab_cadastro";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                lista.add(cadastro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cadastro buscar() {
        return null;
    }
}
