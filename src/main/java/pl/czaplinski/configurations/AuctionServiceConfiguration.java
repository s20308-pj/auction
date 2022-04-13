package pl.czaplinski.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.czaplinski.repositorys.AuctionRepository;
import pl.czaplinski.repositorys.ProductRepository;
import pl.czaplinski.repositorys.UserRepository;
import pl.czaplinski.services.AuctionService;

@Configuration
public class AuctionServiceConfiguration {
    @Bean
    AuctionService auctionService(UserRepository userRepository, ProductRepository productRepository, AuctionRepository auctionRepository){
        return auctionService(userRepository, productRepository, auctionRepository);
    }
}
