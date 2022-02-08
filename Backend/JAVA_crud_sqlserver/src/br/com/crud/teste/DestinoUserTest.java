package br.com.crud.teste;

import br.com.crud.dao.DestinoUserDAO;
import br.com.crud.model.DestinoUser;

public class DestinoUserTest {
	
	
	public static void main(String[] args) {
		DestinoUserDAO DestinoUserDAO = new DestinoUserDAO();
		
		// ------------ Cria um contato e salva no banco
		DestinoUser Destino = new DestinoUser();
		Destino.setPaís("Argentina");
		Destino.setCidade("Lino");
		Destino.setDataSaida("21/05/2232");
		Destino.setDataChegada("21/05/2022");
		
			DestinoUserDAO.save(Destino);
		
		// ------------ Atualiza o contato com id = 1 com os dados do objeto contato1
		/* Autores autor1 = new Autores();
		autor1.setId_autor(1);
		autor1.setNome("Carla");
		autor1.setSobrenome("Andrade");;
		
		autoresDAO.update(autor1);*/
		
		// ------------ Remove o contato com id
		// autoresDAO.removeById(1);
		
		// ------------ Lista todos os contatos do banco de dados
			for (DestinoUser a : DestinoUserDAO.getDestinoUser()) {
				System.out.println("Nome:" + a.getPaís() + "Cidade" + a.getCidade() + "Chegada" + a.getDataChegada() + "Saida" + a.getDataSaida());
			}
		// for (Autores a : autoresDAO.getAutores()) {
			// System.out.println("Nome: " + a.getNome() + " " + a.getSobrenome());
		// }
	}

}


