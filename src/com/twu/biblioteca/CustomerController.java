package com.twu.biblioteca;

import Model.Customer;
import Repositories.CustomerRepository;

import java.util.Scanner;

public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController() {
        customerRepository = new CustomerRepository();
    }

    public Customer LogIn(){
        String user;
        String pwd;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, insert your library number:");
        user = scan.next();
        Customer customer = customerRepository.GetCustomerByLibraryNumber(user);
        System.out.println("Enter your password: ");
        pwd = scan.next();
        if(customer.getPassword().equals(pwd)){
            System.out.println("You are logged now!");
            return customer;
        }
        return null;
    }

    public void ShowCustomerInformation(Customer customer){
        System.out.printf("\n\nName: %s", customer.getName());
        System.out.printf("\nEmail: %s", customer.getEmail());
        System.out.printf("\nPhone number: %s", customer.getPhoneNumber());
    }
}
