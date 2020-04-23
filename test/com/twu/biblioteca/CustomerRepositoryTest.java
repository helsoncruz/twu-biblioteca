package com.twu.biblioteca;

import Model.Customer;
import Repositories.CustomerRepository;
import org.junit.Test;

import static com.sun.tools.doclint.Entity.not;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CustomerRepositoryTest {
    private CustomerRepository repository = new CustomerRepository();

    @Test
    public void ShouldReturnCustomer(){
        Customer customer = repository.GetCustomerByLibraryNumber("123-4567");
        assertThat(customer, notNullValue());
    }
}
