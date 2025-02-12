import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conexao;

    public static void conectar() {
        try {
            if (conexao == null) {
                String url = "jdbc:postgresql://localhost:5432/rocket_db";
                Properties props = new Properties();
                props.setProperty("user", "rocket");
                props.setProperty("password", "password");
                conexao = DriverManager.getConnection(url, props);

                System.out.println("Conexão realizada com sucesso.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
