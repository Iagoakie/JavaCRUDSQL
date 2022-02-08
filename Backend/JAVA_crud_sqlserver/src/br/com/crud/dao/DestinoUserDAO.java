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
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO DestinoUser ( País, Cidade, DataSaida,DataChegada)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parámetro da sql
			// Adicionar o valor do primeiro parámetro da sql
			pstm.setString(1, Destino.getPaís());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, Destino.getCidade());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(3, Destino.getDataSaida());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(4, Destino.getDataChegada());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões
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
		String sql = "UPDATE DestinoUser SET  País = ?, Cidade = ? , DataSaida = ?, DataChegada = ? WHERE Id_Destino = ?";
		

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parámetro da sql
						// Adicionar o valor do primeiro parámetro da sql
						pstm.setString(1, Destino.getPaís());

						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(2, Destino.getCidade());
						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(3, Destino.getDataSaida());
						// Adicionar o valor do segundo parâmetro da sql
						pstm.setString(4, Destino.getDataChegada());



			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
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

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				DestinoUser Destino = new DestinoUser();

				// Recupera o id do banco e atribui ele ao objeto

				// Recupera o nome do banco e atribui ele ao objeto
				Destino.setPaís(rset.getString("País"));
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
