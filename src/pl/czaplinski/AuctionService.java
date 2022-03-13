package pl.czaplinski;

import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class AuctionService {
    Repository repository = new Repository();

    public UUID createNewAuction(String auctionName, Product product, User auctionOwner, int auctionDuration, double currentBid, double buyNowAmount) {
        UUID uuid = UUID.randomUUID();
        repository.addAuctionToList(new Auction(auctionName, uuid, product, auctionOwner, auctionDuration, currentBid, buyNowAmount));
        return uuid;
    }

    public UUID createNewAuction(String auctionName, Product product, User auctionOwner, int auctionDuration, double currentBid) {
        UUID auctionId = UUID.randomUUID();
        repository.addAuctionToList(new Auction(auctionName, auctionId, product, auctionOwner, auctionDuration, currentBid));
        return auctionId;
    }

    public Auction getAuction(UUID auctionId) {
        return repository.getAuctionList().stream().filter(auction -> auction.getUuid().equals(auctionId)).findAny().orElseThrow(null);
    }

    public ArrayList<Auction> getAuctions() {
        return repository.getAuctionList();
    }

    public ArrayList<Auction> searchByProductName(String name) {
        return repository.getAuctionList().stream().filter(auction -> auction.getProduct().getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Auction> searchByAuctionOwnerLastName(String name) {
        return repository.getAuctionList().stream().filter(auction -> auction.getAuctionOwner().getLastName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }


    public boolean makeAnOffer(UUID auctionID, double amount) {
        if (getAuction(auctionID) != null && getAuction(auctionID).getCurrentBid() < amount) {
            getAuction(auctionID).setCurrentBid(amount);
            return true;
        }
        return false;
    }

    public boolean buy(UUID auctionId) {
        if (getAuction(auctionId) != null && getAuction(auctionId).isBuyNowAvailable()) {
            return true;
        }
        return false;
    }
}
