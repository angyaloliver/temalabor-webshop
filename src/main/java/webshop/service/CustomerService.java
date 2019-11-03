package webshop.service;

import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.Order;

import webshop.repository.CustomerRepository;


public class CustomerService {

    private CustomerRepository customerRepository;

    void addCustomer(CustomerContact cc){
        Customer c = Customer.createNewWithId(cc);
        customerRepository.save(c);
    }

    void deleteCustomer(int customerId){
        Customer c = customerRepository.findbyId(customerId);
        customerRepository.delete(c);
    }

    void changeContact(int customerId, CustomerContact customerContact){
        Customer c = customerRepository.findbyId(customerId);
        c.setContact(customerContact);
        customerRepository.save(c);
    }

    void addOrder(Order order, int customerId){
        Customer c = customerRepository.findbyId(customerId);
        c.addOrder(order);
        customerRepository.save(c);
    }
}
