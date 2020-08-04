package app.service;

import app.entity.Customer;
import app.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomersSearchService {

    private final CustomerRepo repo;

    public List<Customer> getCustomersByLoanAndPeriod(int loan, int period) {
        int payableValuePerMonth = loan / period;
        return repo.findAll().stream().filter(c -> c.maxPayableValue >= payableValuePerMonth)
                .sorted(Comparator.comparingInt(c -> c.overdueInDays)).collect(Collectors.toList());
    }
}
