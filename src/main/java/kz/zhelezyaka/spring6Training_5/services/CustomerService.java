package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID uuid);

    List<Customer> getAllCustomers();

    Customer saveNewCustomer(Customer customer);
}
