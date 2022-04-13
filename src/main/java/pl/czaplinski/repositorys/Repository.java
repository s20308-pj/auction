package pl.czaplinski.repositorys;


import pl.czaplinski.models.Auction;
import java.util.ArrayList;
import java.util.UUID;

@org.springframework.stereotype.Repository

public class Repository {

    private ArrayList<Auction> auctionList = new ArrayList<>();

    public ArrayList<Auction> getAuctionList() {
        return auctionList;
    }

    public void addAuctionToList(Auction auction) {
        auctionList.add(auction);
            }

    public Auction findById(UUID uuid) {
        return auctionList.stream().filter((Auction a) -> a.getUuid() == uuid).findFirst().orElse(null);
    }
}