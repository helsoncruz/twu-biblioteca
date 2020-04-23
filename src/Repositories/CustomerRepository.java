package Repositories;

import Model.Customer;

import java.util.ArrayList;

public class CustomerRepository {
    private ArrayList<Customer> repository;

    public CustomerRepository() {
        InitializeCustomerRepository();
    }

    private void InitializeCustomerRepository(){
        repository = new ArrayList<Customer>();
        this.repository.add(new Customer("123-4567","12345", "Wilbert", "wilbert@thoughtworks.com","991118061"));
        this.repository.add(new Customer("890-1012","12345", "Sarah", "sarah@thoughtworks.com","991118062"));
    }

    public Customer GetCustomerByLibraryNumber(String libraryNumber){
        return repository.stream().filter(s -> s.getLibraryNumber().equals(libraryNumber)).findAny().orElse(null);
    }
}
