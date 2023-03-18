package kz.zhelezyaka.spring6Training_5.mappers;

import kz.zhelezyaka.spring6Training_5.entities.Customer;
import kz.zhelezyaka.spring6Training_5.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDTOToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
