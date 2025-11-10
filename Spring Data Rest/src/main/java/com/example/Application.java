package com.example;

import com.example.entity.Client;
import com.example.entity.Compte;
import com.example.entity.TypeCompte;
import com.example.repository.ClientRepository;
import com.example.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            ClientRepository clientRepository,
                            RepositoryRestConfiguration restConfiguration) {
        return args -> {
            // ✅ Permet d'afficher les IDs dans les réponses JSON
            restConfiguration.exposeIdsFor(Client.class, Compte.class);

            // ✅ Création de clients
            Client c1 = clientRepository.save(new Client(null, "Amal", "amal@gmail.com", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", "ali@gmail.com", null));


            // ✅ Création de comptes associés
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            // ✅ Affichage dans la console
            compteRepository.findAll().forEach(c -> System.out.println(c.toString()));
        };
    }
}