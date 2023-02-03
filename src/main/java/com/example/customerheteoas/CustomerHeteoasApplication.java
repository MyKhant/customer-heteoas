package com.example.customerheteoas;

import com.example.customerheteoas.dao.AddressDao;
import com.example.customerheteoas.dao.CustomerDao;
import com.example.customerheteoas.ds.Address;
import com.example.customerheteoas.ds.Customer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class CustomerHeteoasApplication {

    private final CustomerDao customerDao;

    private final AddressDao addressDao;

    public CustomerHeteoasApplication(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner runner(){
        return r->{
            Customer customer1 = new Customer("TH", "Thomas", "Hardy", "thomas@gmail.com");
            Customer customer2 = new Customer("JN", "John", "Doe", "john@gmail.com");

            Address address1 = new Address("11", "Park Avenue", "Yangon", "123");
            Address address2 = new Address("12", "Creek Bridge", "Yangon", "125");
            Address address3 = new Address("13", "Dream Land", "Mandalay", "126");
            Address address4 = new Address("14", "Love Lane", "Yangon", "127");

            customer1.addAddress(address1);
            customer1.addAddress(address2);
            customer2.addAddress(address3);
            customer2.addAddress(address4);

            customerDao.save(customer1);
            customerDao.save(customer2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerHeteoasApplication.class, args);
    }

}
