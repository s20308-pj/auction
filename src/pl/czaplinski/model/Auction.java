package pl.czaplinski.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Auction {
    private UUID uuid;
    private final Product product;
    private final User auctionOwner;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private double currentBid;
    private final double buyNowAmount;
    private final boolean buyNowAvailable;

    public Auction(Product product, User auctionOwner, int auctionDuration, double currentBid,
                   double buyNowAmount, boolean buyNowAvailable) {


        this.uuid = UUID.randomUUID();
        this.product = product;
        this.auctionOwner = auctionOwner;
        this.startDate = LocalDateTime.now();
        this.endDate = startDate.plusDays(auctionDuration);
        this.currentBid = currentBid;
        this.buyNowAmount = buyNowAmount;
        this.buyNowAvailable = buyNowAvailable;
    }

    public Product getProduct() {
        return product;
    }

    public User getAuctionOwner() {
        return auctionOwner;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getBuyNowAmount() {
        return buyNowAmount;
    }

    public boolean isBuyNowAvailable() {
        return buyNowAvailable;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UUID - ").append(uuid).append("\n");
        stringBuilder.append("product - ").append(product.getName()).append("\n");
        stringBuilder.append("product Owner - ").append(auctionOwner.getLastName());
        stringBuilder.append(" ").append(auctionOwner.getFirstName()).append("\n");
        stringBuilder.append("startDate - ").append(startDate.getMonth()).append("-").append(startDate.getDayOfMonth());
        stringBuilder.append(" ").append(startDate.getHour()).append("-").append(startDate.getMinute()).append("\n");
        stringBuilder.append("endDate - ").append(endDate.getMonth()).append("-").append(endDate.getDayOfMonth());
        stringBuilder.append(" ").append(endDate.getHour()).append("-").append(endDate.getMinute()).append("\n");
        stringBuilder.append("current bid - ").append(currentBid).append("\n");
        if (buyNowAvailable) {
            stringBuilder.append("buy now price - ").append(buyNowAmount);
        } else {
            stringBuilder.append("buy now is not available");
        }
        return stringBuilder.toString();
    }
}
