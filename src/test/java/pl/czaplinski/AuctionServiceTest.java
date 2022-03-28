package pl.czaplinski;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;
import pl.czaplinski.repository.Repository;
import pl.czaplinski.service.AuctionService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

class AuctionServiceTest {

    Product product1 = new Product("Opel Astra", "Funkiel nówka, nie śmigany", "/opel.img");
    Product product2 = new Product("VW Pasat", "Niemiec płakał jak sprzedawał", "/pasek.img");

    User user1 = new User("Janusz", "KOKS", "kos@gmail.com");
    User user2 = new User("Zenon", "KACZMAR", "zecie@gmail.com");

    @Test
    void shouldCreateNewAuction() {

        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        //when
        UUID auctionUUID = auctionService.createNewAuction("test Fiat selling", product1, user1, 10, 10000, 15000);

        //then
        Assertions.assertEquals(repository.findById(auctionUUID).getUuid(), auctionUUID);
    }

    @Test
    void shouldFindAuctionGetAuction() {

        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);

        //when
        Optional<Auction> testAuction1 = auctionService.getAuction(auctionId1);

        //then
        Assertions.assertEquals(repository.findById(auctionId1), testAuction1.get());
    }

    @Test
    void shouldNotFindAuctionGetAuction() {

        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        //when
        Optional<Auction> testAuction1 = auctionService.getAuction(auctionId1);
        Optional<Auction> testAuction2 = auctionService.getAuction(auctionId2);

        //then
        Assertions.assertNotEquals(repository.findById(auctionId2), testAuction1.get());
        Assertions.assertNotEquals(repository.findById(auctionId1), testAuction2.get());
    }

    @Test
    void shouldGetAuctions() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        ArrayList<Auction> auctionList = repository.getAuctionList();

        //when
        Optional<ArrayList<Auction>> auctions = auctionService.getAuctions();

        //then
        Assertions.assertEquals(auctionList, auctions.get());
    }

    @Test
    void shouldFindAuctionSearchByProductName() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        //when
        Optional<Auction> testedAuction1 = auctionService.getAuction(auctionId1);
        Optional<Auction> testedAuction2 = auctionService.getAuction(auctionId2);

        //then
        Assertions.assertEquals(repository.findById(auctionId1), testedAuction1.get());
        Assertions.assertEquals(repository.findById(auctionId2), testedAuction2.get());
    }

    @Test
    void shouldNotFindAuctionSearchByProductName() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        //when
        Optional<Auction> testedAuction1 = auctionService.getAuction(auctionId1);
        Optional<Auction> testedAuction2 = auctionService.getAuction(auctionId2);

        //then
        Assertions.assertNotEquals(repository.findById(auctionId2), testedAuction1.get());
        Assertions.assertNotEquals(repository.findById(auctionId1), testedAuction2.get());
    }

    @Test
    void searchByAuctionOwnerLastName() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId1 = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);
        UUID auctionId2 = auctionService.createNewAuction("Pasek w super stanie", product2, user2, 30, 15000);

        //when
        ArrayList<Auction> auctions = auctionService.searchByAuctionOwnerLastName("KOKS");

        //then
        Assertions.assertEquals(repository.findById(auctionId1), auctions.get(0));
        Assertions.assertNotEquals(repository.findById(auctionId2), auctions.get(0));

    }


    @Test
    void shouldRaiseBidMakeAnOffer() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);


        UUID auctionId = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);

        //when
        boolean isRaised = auctionService.makeAnOffer(auctionId, 5500);

        //then
        Assertions.assertTrue(isRaised);
    }

    @Test
    void shouldNotRaiseBidMakeAnOffer() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);

        UUID randomUUID = UUID.randomUUID();

        //when
        boolean isRaised = auctionService.makeAnOffer(auctionId, 4500);
        boolean auctionNotFound = auctionService.makeAnOffer(randomUUID, 4500);

        //then
        Assertions.assertFalse(isRaised);
        Assertions.assertFalse(auctionNotFound);
    }

    @Test
    void buy() {
        //given
        Repository repository = new Repository();
        AuctionService auctionService = new AuctionService(repository);

        UUID auctionId = auctionService.createNewAuction("Tani Opel", product1, user1, 25, 5000, 9000);

        //when
        boolean isBoughtProduct = auctionService.buy(auctionId);

        //then
        Assertions.assertTrue(isBoughtProduct);
    }
}