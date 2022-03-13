package pl.czaplinski;

import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService();
        Product product1 = new Product("Opel Astra", "Funkiel nówka, nie śmigany", "/opel.img");
        Product product2 = new Product("WV Pasat", "Niemiec płakał jak sprzedawał", "/pasek.img");

        User user1 = new User("Janusz", "KOKS", "kos@gmail.com");
        User user2 = new User("Zenon", "CIENIAS", "zecie@gmail.com");

        UUID auctionId1 = auctionService.createNewAuction("tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        System.out.println(auctionId1);
        System.out.println(auctionId2);
        System.out.println("test getAuction");
        System.out.println(auctionService.getAuction(auctionId1).toString());
        System.out.println("test getAuctions");
        auctionService.getAuctions().forEach(a -> System.out.println(a.toString()));
        System.out.println("test searchByAuctionOwnerLastName");
        auctionService.searchByAuctionOwnerLastName("KO").forEach(a-> System.out.println(a.toString()));
        System.out.println("test searchByProductName");
        auctionService.searchByProductName("WV").forEach(a -> System.out.println(a.toString()));
        System.out.println("test buy");
        if (auctionService.buy(auctionId1)) {
            System.out.println("udało się kupić przedmiot");
        } else {
            System.out.println("zakup się nie udał");
        }
        System.out.println("test makeAnOffer");
        if (auctionService.makeAnOffer(auctionId1, 5500)) {
            System.out.println("udało się podbić cenę");
        } else {
            System.out.println("nie udało się podbić ceny");
        }
    }
}
