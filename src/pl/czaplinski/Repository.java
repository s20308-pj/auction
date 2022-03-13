package pl.czaplinski;


import pl.czaplinski.model.Auction;
import pl.czaplinski.model.Product;
import pl.czaplinski.model.User;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<User> userList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Auction> auctionList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUserToList(User user) {
        userList.add(user);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToList(Product product) {
        productList.add(product);
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void addAuctionToList(Auction auction) {
        this.auctionList.add(auction);
    }
}
