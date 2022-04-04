package pl.czaplinski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czaplinski.repository.AuctionRepository;
import pl.czaplinski.repository.ProductRepository;
import pl.czaplinski.repository.Repository;
import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;
import pl.czaplinski.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuctionService {
//    public AuctionService(Repository repository) {
//        this.repository = repository;
//    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AuctionRepository auctionRepository;



    Repository repository = null;

    public UUID createNewAuction(String auctionName, Long productId, Long auctionOwnerId, int auctionDuration, double currentBid, double buyNowAmount) {
        UUID randomUUID = UUID.randomUUID();
        auctionRepository.save(new Auction(auctionName, randomUUID, productRepository.getById(productId), userRepository.getById(auctionOwnerId), auctionDuration, currentBid, buyNowAmount));
        return randomUUID;
    }

    public UUID createTestAuction(){
        UUID randomUUID = UUID.randomUUID();
        auctionRepository.save(new Auction("test1",randomUUID,productRepository.getById(1l),userRepository.getById(1l),20,20.99));
        randomUUID = UUID.randomUUID();
        auctionRepository.save(new Auction("test2",randomUUID,productRepository.getById(2l),userRepository.getById(1l),20,500, 749.99));
        return randomUUID;
    }

    public UUID createNewAuction(Auction auction) {
        UUID randomUUID = UUID.randomUUID();
        auctionRepository.save(auction);
        return randomUUID;
    }

    public Auction getAuction(UUID auctionId) {
        return auctionRepository.getById(auctionId);
    }

    public List<Auction> getAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> searchByProductName(String name) {
        return getAuctions().stream().filter(auction -> auction.getProduct().getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public List<Auction> searchByAuctionOwnerLastName(String name) {
        return getAuctions().stream().filter(auction -> auction.getAuctionOwner().getLastName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
    public boolean makeAnOffer(UUID auctionID, double amount) {
        if (getAuction(auctionID)!= null && getAuction(auctionID).getCurrentBid() < amount) {
            getAuction(auctionID).setCurrentBid(amount);
            return true;
        }
        return false;
    }

    public boolean buy(UUID auctionId) {
        return getAuction(auctionId)!= null && getAuction(auctionId).isBuyNowAvailable();
    }
}
