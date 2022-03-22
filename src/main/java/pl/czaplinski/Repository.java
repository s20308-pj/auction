package pl.czaplinski;


import pl.czaplinski.model.Auction;
import java.util.ArrayList;

@org.springframework.stereotype.Repository
public class Repository {

    private ArrayList<Auction> auctionList = new ArrayList<>();

    public ArrayList<Auction> getAuctionList() {
        return auctionList;
    }

    public void addAuctionToList(Auction auction) {
        auctionList.add(auction);
    }
}
