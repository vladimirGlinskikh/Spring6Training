package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Vladimir")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Angelina")
                .version(2)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Svetlana")
                .version(3)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("Get Customer by ID - in service. ID: " + id.toString());
        return customerMap.get(id);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .version(customer.getVersion())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .build();
        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(customer.getVersion());
        existing.setCreatedDate(LocalDateTime.now());
        existing.setUpdateDate(LocalDateTime.now());

        customerMap.put(existing.getId(), customer);
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existing.setCustomerName(customer.getCustomerName());
        }
        if (customer.getVersion() != null) {
            existing.setVersion(customer.getVersion());
        }
        if (customer.getCreatedDate() != null) {
            existing.setCreatedDate(customer.getCreatedDate());
        }
        if (customer.getUpdateDate() != null) {
            existing.setUpdateDate(customer.getUpdateDate());
        }
    }
}
