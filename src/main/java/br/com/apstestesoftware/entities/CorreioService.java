package br.com.apstestesoftware.entities;

public class CorreioService {
	
	public String buscaEndereco(String cep) {
		
		if(cep.equals("9000000")) {
			
			return "Porto Alegre";
			
		} else if (cep.equals("8000000")) {
			
			return "Av. Assis Brasil";
		}
		
		return "Endereço não encontrado";
		
	}

}
