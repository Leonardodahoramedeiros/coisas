package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	
	private static BancoDeDados instancia;
	private static String url = "jdbc:mysql://localhost:3306/coisas";
    private static String user = "root";
    private static String password = "";
    private Connection connection;

	
	private BancoDeDados () {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	public static BancoDeDados getInstancia() {
		if(instancia == null) {
			instancia = new BancoDeDados();
			return instancia;
		}else{
			return instancia;
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
