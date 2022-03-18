package pl.czaplinski;

import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);
        Product product1 = new Product("Opel Astra", "Funkiel nówka, nie śmigany", "/opel.img");
        Product product2 = new Product("VW Pasat", "Niemiec płakał jak sprzedawał", "/pasek.img");

        User user1 = new User("Janusz", "KOKS", "kos@gmail.com");
        User user2 = new User("Zenon", "KACZMAR", "zecie@gmail.com");

        UUID auctionId1 = auctionService.createNewAuction("tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

//        UUID auctionId1 = UUID.randomUUID();
//        UUID auctionId2 = UUID.randomUUID();

        System.out.println(auctionId1);
        System.out.println(auctionId2);

        System.out.printf("--test getAuction should pass: UUID: %s--\n", auctionId1);

        auctionService
                .getAuction(auctionId1)
                .ifPresentOrElse(
                        a -> System.out.println(a.toString()),
                        () -> System.out.println("Brak Aukcji")
                );
        System.out.printf("--test getAuction should fail: UUID: random--\n");

        auctionService
                .getAuction(UUID.randomUUID())
                .ifPresentOrElse(
                        a -> System.out.println(a.toString()),
                        () -> System.out.println("Brak Aukcji")
                );


        System.out.println("--test getAuctions--");
        auctionService
                .getAuctions()
                .ifPresentOrElse(
                        a -> System.out.println(a.toString()),
                        () -> System.out.println("Brak Aukcji"));


        System.out.println("--test searchByAuctionOwnerLastName--");
        auctionService.searchByAuctionOwnerLastName("K").forEach(
                a -> System.out.println(a.toString()));

        System.out.println("--test searchByProductName--");
        auctionService.searchByProductName("VW").forEach(a -> System.out.println(a.toString()));

        System.out.println("--test buy--");
        if (auctionService.buy(auctionId1)) {
            System.out.println("udało się kupić przedmiot");
        } else {
            System.out.println("zakup się nie udał");
        }

        System.out.println("--test makeAnOffer--");
        if (auctionService.makeAnOffer(auctionId1, 5500)) {
            System.out.println("udało się podbić cenę");
        } else {
            System.out.println("nie udało się podbić ceny");
        }
    }
}
