package io.github.wotjd243.aladin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackageClasses = {Buyer.class})
//@EnableJpaRepositories(basePackageClasses = {BuyerRepository.class})
public class AladinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AladinApplication.class, args);
    }
}
