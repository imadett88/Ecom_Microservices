package org.sid.billlingservice;

import org.sid.billlingservice.entities.Bill;
import org.sid.billlingservice.entities.ProductItem;
import org.sid.billlingservice.model.Customer;
import org.sid.billlingservice.model.Product;
import org.sid.billlingservice.repository.BillRepository;
import org.sid.billlingservice.repository.ProductItemRepository;
import org.sid.billlingservice.services.CustomerRestClient;
import org.sid.billlingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients //pour connaître les 2 interface basé sur OpenFeign
public class BilllingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilllingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient){
        return args -> {
            Collection<Product> products=productRestClient.allProducts().getContent();
            Long customerId=1L;
            Customer customer=customerRestClient.findCustomerById(customerId);
            if(customer==null) throw new RuntimeException("Customer not found");
            Bill bill=new Bill();
            bill.setBillDate(new Date());
            bill.setCustomerId(customerId);
            Bill savedBill = billRepository.save(bill);
            products.forEach(product -> {
                ProductItem productItem=new ProductItem();
                productItem.setBill(savedBill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1+new Random().nextInt(10));
                productItem.setPrice(product.getPrice());
                productItem.setDiscount(Math.random());
                productItemRepository.save(productItem);
            });

        };
    }

}