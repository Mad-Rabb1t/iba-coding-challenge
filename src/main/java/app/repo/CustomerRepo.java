package app.repo;

import app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    <S extends Customer> S save(S s);

    Optional<Customer> findByMaxPayableValue(int value);
    List<Customer> findAll();
}
