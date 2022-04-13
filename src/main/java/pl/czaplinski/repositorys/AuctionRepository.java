package pl.czaplinski.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.czaplinski.models.Auction;

import java.util.UUID;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, UUID> {
}
