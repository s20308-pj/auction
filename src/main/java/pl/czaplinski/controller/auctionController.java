package pl.czaplinski.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;
import pl.czaplinski.repository.Repository;
import pl.czaplinski.service.AuctionService;

import java.util.ArrayList;
import java.util.UUID;


@RestController
@RequestMapping("/auction")
public class auctionController {

    Repository repository = new Repository();
    AuctionService auctionService = new AuctionService(repository);

    // database filling
    Product product1 = new Product("Opel Astra", "Funkiel nówka, nie śmigany", "/opel.img");
    Product product2 = new Product("VW Pasat", "Niemiec płakał jak sprzedawał", "/pasek.img");

    User user1 = new User("Janusz", "KOKS", "kos@gmail.com");
    User user2 = new User("Zenon", "KACZMAR", "zecie@gmail.com");

    UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
    UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

    @GetMapping("/")
    public ResponseEntity<ArrayList<Auction>> getAuctions() {
        return ResponseEntity.ok(auctionService.getAuctions().get());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Auction> getAuction(@PathVariable UUID uuid) {
        return ResponseEntity.ok(auctionService.getAuction(uuid).get());
    }
}

