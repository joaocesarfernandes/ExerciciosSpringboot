package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import entity.Pessoa;
import repository.PessoaRepository;

@Component
public class CommandLine implements CommandLineRunner {

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public void run(String... arg0) throws Exception {
		Pessoa p = new Pessoa();
		p.setNome("João");
		p.setId(26);
		p.setEndereco("Francisco Cordeiro, 45");
		p.setBairro("Biritiba");
		p.setCidade("Poá");
		p.setEstado("SP");
		
		repository.save(p);
	}

}
