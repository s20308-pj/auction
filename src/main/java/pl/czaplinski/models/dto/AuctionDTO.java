package pl.czaplinski.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuctionDTO {
    private String auctionName;
    private Long productId;
    private Long auctionOwnerId;
    private int auctionDuration;
    private double currentBid;
    private double buyNowAmount;
}
