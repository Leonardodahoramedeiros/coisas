package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.*;


public class ClienteDAO {
    public static Cliente find_one(int cpf) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "SELECT * FROM clientes WHERE cpf = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, cpf);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");

                cliente = new Cliente(id, nome, cpf, telefone);
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

        return cliente;
    }
    
    public static Cliente find_one_by_id(int id) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "SELECT * FROM clientes WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                int cpf = rs.getInt("cpf");

                cliente = new Cliente(id, nome, cpf, telefone);
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

        return cliente;
    }
    
    
	public static void updateCliente(Cliente cliente) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        String query = "UPDATE clientes SET cpf = ?, nome = ?, telefone = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            
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
	
	public static void saveCliente(Cliente cliente) {
        Connection conn = BancoDeDados.getInstancia().getConnection();
        Cliente result = find_one_by_id(cliente.getId());
        if(result != null) {
        	updateCliente(cliente);
        }else {
        	 String query = "INSERT INTO clientes (nome, telefone, cpf) VALUES (?, ?, ?)";
             PreparedStatement stmt = null;
             
             try {
                 stmt = conn.prepareStatement(query);
                 stmt.setString(1, cliente.getNome());
                 stmt.setString(2, cliente.getTelefone());
                 stmt.setInt(3, cliente.getCpf());
                 
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
	
	 public static void deleteCliente(Cliente cliente) {
	        Connection conn = BancoDeDados.getInstancia().getConnection();
	     
	        if(cliente.getId() != -1) {
	        	String query = "DELETE FROM clientes WHERE id = ?";
	   	        
	        	PreparedStatement stmt = null;
	        	try {
		            stmt = conn.prepareStatement(query);
		            stmt.setInt(1, cliente.getId());
		            
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
                System.out.println("Tentando excluir cliente que nao esta salvo");

	        }
	        
	    }
	
	
    
}