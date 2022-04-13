package pl.czaplinski.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.czaplinski.models.dto.AuctionDTO;
import pl.czaplinski.repositorys.AuctionRepository;
import pl.czaplinski.repositorys.ProductRepository;
import pl.czaplinski.models.Auction;
import pl.czaplinski.repositorys.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AuctionRepository auctionRepository;

    public UUID createNewAuction(AuctionDTO auctionDTO) {
        UUID randomUUID = UUID.randomUUID();
        if (auctionDTO.getBuyNowAmount() <= 0) {
            auctionRepository.save(
                    new Auction(auctionDTO.getAuctionName(),
                            randomUUID,
                            productRepository.getById(auctionDTO.getProductId()),
                            userRepository.getById(auctionDTO.getAuctionOwnerId()),
                            auctionDTO.getAuctionDuration(),
                            auctionDTO.getCurrentBid()
                    ));
        } else {
            auctionRepository.save(
                    new Auction(auctionDTO.getAuctionName(),
                            randomUUID,
                            productRepository.getById(auctionDTO.getProductId()),
                            userRepository.getById(auctionDTO.getAuctionOwnerId()),
                            auctionDTO.getAuctionDuration(),
                            auctionDTO.getCurrentBid(),
                            auctionDTO.getBuyNowAmount()
                    ));
        }
        System.out.println(randomUUID);
        return randomUUID;
    }

    public Auction getAuction(UUID uuid) {
        return auctionRepository.getById(uuid);
    }

    public List<Auction> getAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> searchByProductName(String name) {
        return getAuctions()
                .stream()
                .filter(
                        auction -> auction.getProduct()
                                .getName()
                                .toLowerCase()
                                .contains(name.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    public List<Auction> searchByAuctionOwnerLastName(String name) {
        return getAuctions()
                .stream().
                filter(
                        auction -> auction.
                                getAuctionOwner().
                                getLastName().
                                toLowerCase().
                                contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean makeAnOffer(UUID auctionID, double amount) {
        if (getAuction(auctionID) != null && getAuction(auctionID).getCurrentBid() < amount) {
            getAuction(auctionID).setCurrentBid(amount);
            return true;
        }
        return false;
    }

    public boolean buy(UUID auctionId) {
        return getAuction(auctionId) != null && getAuction(auctionId).isBuyNowAvailable();
    }

    public UUID createTestAuction() {
        UUID randomUUID = UUID.randomUUID();
        auctionRepository.save(
                new Auction(
                        "test",
                        randomUUID,
                        productRepository.getById(1L),
                        userRepository.getById(1L),
                        10,
                        10000,
                        15000));
        return randomUUID;
    }
}
