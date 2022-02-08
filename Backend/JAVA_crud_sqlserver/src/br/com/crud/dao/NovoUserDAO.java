package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.DestinoUser;
import br.com.crud.model.NovoUser;

public class NovoUserDAO {
	
	
	
	public void save(NovoUser User) {
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO NovoUsers ( Nome, CPF, Email, DestinoUserId_Destino)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parámetro da sql
			pstm.setString(1, User.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, User.getCPF());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(3, User.getEmail());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(4, User.getDestinoUserId_Destino());

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

	public void removeById(int Id) {
		String sql = "DELETE FROM NovoUsers WHERE Id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Id);

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

	public void update(NovoUser User) {
		String sql = "UPDATE NovoUsers SET  Nome = ?, CPF = ? , Email = ?, DestinoUserId_Destino = ? WHERE Id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

	
	
			// Adicionar o valor do primeiro parámetro da sql
			pstm.setString(1, User.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, User.getCPF());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(3, User.getEmail());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(4, User.getDestinoUserId_Destino());
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

	public List<NovoUser> getNovoUser() {

		String sql = "select * from NovoUsers as l inner join DestinoUser as a on l.DestinoUserId_Destino = a.Id_Destino";

		List<NovoUser> NovoUsers = new ArrayList<NovoUser>();

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
				
				NovoUser User = new NovoUser();
				
	            Destino.setPaís(rset.getString("País"));
	            Destino.setCidade(rset.getString("Cidade"));
	            Destino.setDataSaida(rset.getString("DataSaida"));
	            Destino.setDataChegada(rset.getString("DataChegada"));
	            
	                    
				User.setDestinoUser(Destino);
				
				// Recupera o nome do banco e atribui ele ao objeto
				User.setNome(rset.getString("Nome"));
				// Recupera o nome do banco e atribui ele ao objeto
				User.setCPF(rset.getString("CPF"));
				// Recupera o nome do banco e atribui ele ao objeto
				User.setEmail(rset.getString("Email"));
				// Recupera o nome do banco e atribui ele ao objeto
				User.setDestinoUserId_Destino(rset.getString("Email"));

				// Adiciona o contato recuperado, a lista de contatos
				NovoUsers.add(User);
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
		
		return NovoUsers;
	
	}

	
	}


