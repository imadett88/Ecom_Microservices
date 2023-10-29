package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Customer.class);
            //dans spring rest : solution pour afficher l'id
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Imad").email("imad@gmail.com").build(),
                            Customer.builder().name("Yassin").email("yassin@gmail.com").build(),
                            Customer.builder().name("Said").email("said@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }

}
