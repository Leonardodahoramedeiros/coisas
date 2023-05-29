package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.*;


	public class ServicosContratadosDAO {
		
		public static void saveServiçosContratados(ServicosContratados sc) {
		Connection conn = BancoDeDados.getInstancia().getConnection();
		ServicosContratados result = find_one_by_id(sc.getId());
		
		if(result != null) {
			updateServicoscontratados(sc);
		}else {
			String query = "INSERT into servicoscontratados (data_servico,cliente_id,prestador_id,servico_id,valor) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = null;
			
			try {
				stmt = conn.prepareStatement(query);
                stmt.setString(1, sc.getData());
                stmt.setInt(2, sc.getCliente().getId());
                stmt.setInt(3, sc.getPrestador().getId());
                stmt.setInt(4, sc.getServicos().getId());
                stmt.setDouble(5, sc.getValor());
                
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("ServicosContratados salvos com sucesso!");
                } else {
                    System.out.println("Nao inseriu o servicoscontratados por algum motivo.");
                } 
				
			}catch (SQLException e) {
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
		
		public static ServicosContratados find_one_by_id(int id) {
			Connection conn = BancoDeDados.getInstancia().getConnection();
			String query = "SELECT * FROM servicoscontratados WHERE id = ?";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ServicosContratados sc = null;
			
			try {
				stmt = conn.prepareStatement(query);
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();
		
			if (rs.next()) {
            	
				
                String data_servico = rs.getString("data_servico");
                int cliente_id = rs.getInt("cliente_id");
                int prestador_id = rs.getInt("prestador_id");
                int servicos_id = rs.getInt("servicos_id");
                double valor = rs.getDouble("valor");
                
                Cliente cliente = ClienteDAO.find_one_by_id(cliente_id);
                Servicos servicos = ServicosDAO.find_one_by_id(servicos_id);
                Prestador prestador = PrestadorDAO.find_one_by_id(prestador_id);
                
               
                sc = new ServicosContratados(id,data_servico,cliente,servicos, prestador,valor);
				}
            }catch (SQLException e) {
            	
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

            return sc;
		}
		public static void updateServicoscontratados(ServicosContratados sc) {
	        Connection conn = BancoDeDados.getInstancia().getConnection();
	        String query = "UPDATE servicoscontratados SET data_servico = ?, cliente_id = ?, prestador_id = ?, servicos_id = ?, valor = ? WHERE id = ?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement(query);
	            stmt.setString(1, sc.getData());
                stmt.setInt(2, sc.getCliente().getId());
                stmt.setInt(3, sc.getPrestador().getId());
                stmt.setInt(4, sc.getServicos().getId());
                stmt.setDouble(5, sc.getValor());
	            
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Servicocontratado atualizado com sucesso!");
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
	}		
			

			
			
			





