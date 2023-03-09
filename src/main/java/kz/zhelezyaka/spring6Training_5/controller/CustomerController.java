package kz.zhelezyaka.spring6Training_5.controller;

import kz.zhelezyaka.spring6Training_5.model.Customer;
import kz.zhelezyaka.spring6Training_5.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PutMapping("{customerId}")
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId,
                                     @RequestBody Customer customer) {
        customerService.updateCustomerById(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                "/api/v1/customer/" +
                        savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId) {

        customerService.deleteById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
