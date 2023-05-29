package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Servicos;

public class ServicosDAO {
	
	public static Servicos find_one(String tipo) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "SELECT * FROM servicos WHERE tipo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicos servico = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	int id = rs.getInt("id");

                servico = new Servicos(id, tipo);
            }
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return servico;
    }
	
	public static Servicos find_one_by_id(int id) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "SELECT * FROM servicos WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicos servico = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	String tipo = rs.getString("tipo");

                servico = new Servicos(id, tipo);
            }
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return servico;
    }
    
	public static void updateServico(Servicos servico) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "UPDATE Servicos SET tipo = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, servico.getTipo());
            stmt.setInt(2, servico.getId());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Nenhum cliente foi atualizado.");
            }
        } catch (SQLException e) {
            // Tratar a exceção, registrar o erro, exibir uma mensagem, etc.
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar o PreparedStatement e a Connection no final
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void saveServicos(Servicos servico) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        Servicos result = find_one_by_id(servico.getId());
        if(result != null) {
        	updateServico(servico);
        }else {
        	 String query = "INSERT INTO servicos (tipo) VALUES (?)";
             PreparedStatement stmt = null;
             
             try {
                 stmt = conn.prepareStatement(query);
                 stmt.setString(1, servico.getTipo());
                 
                 
                 int rowsAffected = stmt.executeUpdate();
                 if (rowsAffected > 0) {
                     System.out.println("Cliente Salvo com sucesso!");
                 } else {
                     System.out.println("Nao inseriu o cliente por algum motivo.");
                 }
             } catch (SQLException e) {
                 // Tratar a exceção, registrar o erro, exibir uma mensagem, etc.
                 e.printStackTrace();
             } finally {
                 // Certifique-se de fechar o PreparedStatement e a Connection no final
                 try {
                     if (stmt != null) {
                         stmt.close();
                     }
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
        }
       
        
	}
	
	 public static void deleteServicos(Servicos servico) {
	        Connection conn = BancoDeDados.getInstancia().getConnection();
	      
	        if(find_one_by_id(servico.getId()) != null) {
	        	String query = "DELETE FROM servicos WHERE id = ?";
	  	        PreparedStatement stmt = null;
	        	try {
		            stmt = conn.prepareStatement(query);
		            stmt.setInt(1, servico.getId());
		            
		            int rowsAffected = stmt.executeUpdate();
		            if (rowsAffected > 0) {
		                System.out.println("Cliente excluído com sucesso!");
		            } else {
		                System.out.println("Nenhum cliente foi excluído.");
		            }
		        } catch (SQLException e) {
		            // Tratar a exceção, registrar o erro, exibir uma mensagem, etc.
		            e.printStackTrace();
		        } finally {
		            // Certifique-se de fechar o PreparedStatement e a Connection no final
		            try {
		                if (stmt != null) {
		                    stmt.close();
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
	        }
	        else {
                System.out.println("Tentando excluir cliente que nao esta salvo::erro:???");

	        }
	 }

}
