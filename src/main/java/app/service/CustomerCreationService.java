package app.service;


import app.entity.Customer;
import app.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@AllArgsConstructor
@Service
public class CustomerCreationService {

    private final CustomerRepo repo;

    @Bean
    public void create() {
        repo.deleteAll();
        final Customer customer1 = new Customer();
        customer1.name = "Kamran";
        customer1.surname = "Rzayev";
        customer1.maxPayableValue = 300;
        final Customer customer2 = new Customer();
        customer2.name = "Emin";
        customer2.surname = "Israfilzadeh";
        customer2.maxPayableValue = 600;
        customer2.overdueInDays = 1;
        final Customer customer3 = new Customer();
        customer3.name = "Turkan";
        customer3.surname = "Ismayilova";
        customer3.maxPayableValue = 500;
        customer3.overdueInDays = 3;
        repo.saveAll(Arrays.asList(customer1, customer2, customer3));
    }
}
