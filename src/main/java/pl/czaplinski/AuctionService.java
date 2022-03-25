package pl.czaplinski;

import org.springframework.stereotype.Service;
import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuctionService {
    public AuctionService(Repository repository) {
        this.repository = repository;
    }

    Repository repository = null;

    public UUID createNewAuction(String auctionName, Product product, User auctionOwner, int auctionDuration, double currentBid, double buyNowAmount) {
        UUID randomUUID = UUID.randomUUID();
        repository.addAuctionToList(new Auction(auctionName, randomUUID, product, auctionOwner, auctionDuration, currentBid, buyNowAmount));
        return randomUUID;
    }

    public UUID createNewAuction(String auctionName, Product product, User auctionOwner, int auctionDuration, double currentBid) {
        UUID randomUUID = UUID.randomUUID();
        repository.addAuctionToList(new Auction(auctionName, randomUUID, product, auctionOwner, auctionDuration, currentBid));
        return randomUUID;
    }

    public Optional<Auction> getAuction(UUID auctionId) {
        return repository.getAuctionList().stream().filter(auction -> auction.getUuid().equals(auctionId)).findFirst();
    }

    public Optional<ArrayList<Auction>> getAuctions() {
        return Optional.ofNullable(repository.getAuctionList());
    }

    public ArrayList<Auction> searchByProductName(String name) {
        return repository.getAuctionList().stream().filter(auction -> auction.getProduct().getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Auction> searchByAuctionOwnerLastName(String name) {
        return repository.getAuctionList().stream().filter(auction -> auction.getAuctionOwner().getLastName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }


    public boolean makeAnOffer(UUID auctionID, double amount) {
        if (getAuction(auctionID).isPresent() && getAuction(auctionID).get().getCurrentBid() < amount) {
            getAuction(auctionID).get().setCurrentBid(amount);
            return true;
        }
        return false;
    }

    public boolean buy(UUID auctionId) {
        return getAuction(auctionId).isPresent() && getAuction(auctionId).get().isBuyNowAvailable();
    }
}
