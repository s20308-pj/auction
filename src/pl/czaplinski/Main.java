package pl.czaplinski;

import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product("Opel Astra", "Funkiel nówka, nie śmigany", "/opel.img");
        Product product2 = new Product("WV Pasat", "Niemiec płakał jak sprzedawał", "/pasek.img");

        User user1 = new User("Janusz", "KOKS", "kos@gmail.com", "ul. Koksowa 5, 12-345 Pcim Dolny");
        User user2 = new User("Zenon", "CIENIAS", "zecie@gmail.com", "ul. Wąska 7, 34-456 Kaszlakowo");

        Auction auction1 = new Auction(product1, user1, 10, 1000, 500, true);
        Auction auction2 = new Auction(product2, user2, 7, 1500, 500, false);
        System.out.println(auction1.toString());
        System.out.println(auction2.toString());


    }
}
