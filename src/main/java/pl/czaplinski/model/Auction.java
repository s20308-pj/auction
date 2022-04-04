package pl.czaplinski.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Auction {
    @Id
    private UUID uuid;
    private String auctionName;
    @ManyToOne
    @JoinColumn
    private Product product;
    @ManyToOne
    @JoinColumn
    private User auctionOwner;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double currentBid;
    private double buyNowAmount;
    private boolean buyNowAvailable;

    public Auction(String auctionName, UUID uuid, Product product, User auctionOwner, int auctionDuration, double currentBid, double buyNowAmount) {
        this.auctionName = auctionName;
        this.uuid = uuid;
        this.product = product;
        this.auctionOwner = auctionOwner;
        this.startDate = LocalDateTime.now();
        this.endDate = startDate.plusDays(auctionDuration);
        this.currentBid = currentBid;
        this.buyNowAvailable = true;
        this.buyNowAmount = buyNowAmount;
    }

    public Auction(String auctionName, UUID uuid, Product product, User auctionOwner, int auctionDuration, double currentBid) {
        this.auctionName = auctionName;
        this.uuid = uuid;
        this.product = product;
        this.auctionOwner = auctionOwner;
        this.startDate = LocalDateTime.now();
        this.endDate = startDate.plusDays(auctionDuration);
        this.currentBid = currentBid;
        this.buyNowAvailable = false;
    }

    public Auction() {
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
