package br.com.crud.model;

public class NovoUser {
	    
	        private String Nome;
	      
	        private String CPF ;
	   
	        private String Email ;

	    		
			public String getCPF() {
				return CPF;
			}

			public void setCPF(String cPF) {
				CPF = cPF;
			}


			public String getNome() {
				return Nome;
			}

			public void setNome(String nome) {
				Nome = nome;
			}

			

			public String getEmail() {
				return Email;
			}

			public void setEmail(String email) {
				Email = email;
			}

			
			
			 //FK edição
			
			private String DestinoUserId_Destino;
	        private DestinoUser DestinoUser;


			public String getDestinoUserId_Destino() {
				return DestinoUserId_Destino;
			}

			public void setDestinoUserId_Destino(String destinoUserId_Destino) {
				DestinoUserId_Destino = destinoUserId_Destino;
			}

			public DestinoUser getDestinoUser() {
				return DestinoUser;
			}

			public void setDestinoUser(DestinoUser destinoUser) {
				DestinoUser = destinoUser;
			}

			













	
	
	        

}
