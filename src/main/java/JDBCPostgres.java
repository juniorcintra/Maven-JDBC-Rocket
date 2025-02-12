import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args){
        try {
            String url = "jdbc:postgresql://localhost:5432/rocket_db";
            Properties props = new Properties();
            props.setProperty("user", "rocket");
            props.setProperty("password", "password");
            Connection conn = DriverManager.getConnection(url, props);

            System.out.println("Conexão realizada com sucesso.");

            String sql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?,?);";
            String nome = "Junior Paulo";
            Integer idade = 2;

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2,idade);

            pst.execute();

            System.out.println("Cadastro inserido com sucesso!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
