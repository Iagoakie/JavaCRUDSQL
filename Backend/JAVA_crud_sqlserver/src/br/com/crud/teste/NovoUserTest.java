package br.com.crud.teste;

import br.com.crud.dao.NovoUserDAO;
import br.com.crud.model.NovoUser;

public class NovoUserTest {
	
	public static void main(String[] args) {
	
		NovoUserDAO NovoUserDAO = new NovoUserDAO();
		
		// ------------ Cria um livro e salva no banco
		/*Livros livro = new Livros();
		livro.setNome("João");
		livro.setIsbn(654);
		livro.setPreco(59);
		livro.setId_autor(2);
		livro.setId_editora(1);
		
		livrosDAO.save(livro);*/
		
		// ------------ Atualiza o contato com id = 1 com os dados do objeto contato1
		NovoUser User = new NovoUser();
		User.setNome("maquina");
		User.setCPF("18948946");
		User.setEmail("iagoaki1@gmial.com");
		User.setDestinoUserId_Destino("1");
		
		NovoUserDAO.save(User);
		
		// livrosDAO.removeById(2);
		
		// ------------ Lista todos os contatos do banco de dados
		for (NovoUser l : NovoUserDAO.getNovoUser()) {
			System.out.println("Nome: " + l.getNome() + " | CPF: " + l.getCPF() + " | Email: " + l.getEmail() + " | Cidade: " + l.getDestinoUser().getCidade()
					
					
					+ " | País: " + l.getDestinoUser().getPaís()
					
					+ " | DataChegada: " + l.getDestinoUser().getDataChegada()
					
					+ " | DataSaida: " + l.getDestinoUser().getDataSaida()
					
					
					)
			
			;
		}
	}
}
