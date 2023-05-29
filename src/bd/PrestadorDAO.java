package bd;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	import modelos.Prestador;

	public class PrestadorDAO {
		public static void savePrestador(Prestador prestador) {
			Connection conn = BancoDeDados.getInstancia().getConnection();
			Prestador result = find_one_by_id(prestador.getId());
			
			if (result != null) {
				updatePrestador(prestador);
			} else {
				String query = "INSERT INTO Prestadores (nome, matricula, telefone) VALUES (?, ?, ?)";
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(query);
					stmt.setString(1, prestador.getNome());
					stmt.setString(2, prestador.getMatricula());
					stmt.setString(3, prestador.getTelefone());
					
					int rowsAffected = stmt.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Prestador salvo com sucesso!");
					} else {
						System.out.println("Não foi possível inserir o prestador por algum motivo.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
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

		public static Prestador find_one_by_id(int id) {
			Connection conn = BancoDeDados.getInstancia().getConnection();
			String query = "SELECT * FROM Prestadores WHERE id = ?";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Prestador prestador = null;
			
			try {
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				
				if (rs.next()) {
			
					String nome = rs.getString("nome");
					String matricula = rs.getString("matricula");
					String telefone = rs.getString("telefone");
					
					prestador = new Prestador(id, nome, matricula, telefone);
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
			
			return prestador;
		}

		public static void updatePrestador(Prestador prestador) {
			Connection conn = BancoDeDados.getInstancia().getConnection();
			String query = "UPDATE Prestadores SET nome = ?, matricula = ?, telefone = ? WHERE id = ?";
			PreparedStatement stmt = null;
			
			try {
				stmt = conn.prepareStatement(query);
				stmt.setString(1, prestador.getNome());
				stmt.setString(2, prestador.getMatricula());
				stmt.setString(3, prestador.getTelefone());
				stmt.setInt(4, prestador.getId());
				
				int rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Prestador atualizado com sucesso!");
				} else {
					System.out.println("Nenhum prestador foi atualizado.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
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



