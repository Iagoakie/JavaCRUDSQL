package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.DestinoUser;

public class DestinoUserDAO {
	
	public void save(DestinoUser Destino) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO DestinoUser ( Pa�s, Cidade, DataSaida,DataChegada)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
			// Adicionar o valor do primeiro par�metro da sql
			pstm.setString(1, Destino.getPa�s());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(2, Destino.getCidade());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(3, Destino.getDataSaida());
			// Adicionar o valor do segundo par�metro da sql
			pstm.setString(4, Destino.getDataChegada());

			// Executar a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int Id_Destino) {
		String sql = "DELETE FROM DestinoUser WHERE Id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Id_Destino);

			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(DestinoUser Destino) {
		String sql = "UPDATE DestinoUser SET  Pa�s = ?, Cidade = ? , DataSaida = ?, DataChegada = ? WHERE Id_Destino = ?";
		

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
						// Adicionar o valor do primeiro par�metro da sql
						pstm.setString(1, Destino.getPa�s());

						// Adicionar o valor do segundo par�metro da sql
						pstm.setString(2, Destino.getCidade());
						// Adicionar o valor do segundo par�metro da sql
						pstm.setString(3, Destino.getDataSaida());
						// Adicionar o valor do segundo par�metro da sql
						pstm.setString(4, Destino.getDataChegada());



			// Executa a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<DestinoUser> getDestinoUser() {

		String sql = "SELECT * FROM DestinoUser";

		List<DestinoUser> DestinoUser = new ArrayList<DestinoUser>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, fa�a
			while (rset.next()) {
				DestinoUser Destino = new DestinoUser();

				// Recupera o id do banco e atribui ele ao objeto

				// Recupera o nome do banco e atribui ele ao objeto
				Destino.setPa�s(rset.getString("Pa�s"));
				// Recupera o nome do banco e atribui ele ao objeto
				Destino.setCidade(rset.getString("Cidade"));
				// Recupera o nome do banco e atribui ele ao objeto
				Destino.setDataChegada(rset.getString("DataChegada"));
				// Recupera o nome do banco e atribui ele ao objeto
				Destino.setDataSaida(rset.getString("DataSaida"));

				// Adiciona o contato recuperado, a lista de contatos
				DestinoUser.add(Destino);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return DestinoUser;
	}

}
