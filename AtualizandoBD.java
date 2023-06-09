import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AtualizandoBD6 {
    public static void main(String[] args){
    String SQLatualizarDados = "update pessoa set nome = 'Carlos'";
    String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";
    Statement st = null;
    try(Connection conn = DriverManager.getConnection(driver, "postgres", "27150118")) {
      if(conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }
      System.out.println("Atualizando dados na tabela...");
      st = conn.createStatement();
      st.executeUpdate(SQLatualizarDados);
      System.out.println("Dados atualizados");
      st.close();
      conn.close();
    } catch(SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
    
}
}

