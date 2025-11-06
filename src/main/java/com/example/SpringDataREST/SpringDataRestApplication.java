package com.example.SpringDataREST;

import com.example.SpringDataREST.Repositories.ClientRepository;
import com.example.SpringDataREST.Repositories.CompteRepository;
import com.example.SpringDataREST.entities.Client;
import com.example.SpringDataREST.entities.Compte;
import com.example.SpringDataREST.entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Compte.class);

			Client c1 = clientRepository.save(new Client(null, "Doha", null));
			Client c2 = clientRepository.save(new Client(null, "salwa", null));

			compteRepository.save(new Compte());
			compteRepository.save(new Compte());
			compteRepository.save(new Compte());

			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}