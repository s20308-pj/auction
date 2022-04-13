package pl.czaplinski.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czaplinski.models.Auction;

import pl.czaplinski.models.dto.AuctionDTO;
import pl.czaplinski.services.AuctionService;

import java.util.*;


@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Auction>> getAuctions() {
        return ResponseEntity.ok(auctionService.getAuctions());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Auction> getAuction(@PathVariable UUID uuid) {
        System.out.println(uuid);
        return ResponseEntity.ok(auctionService.getAuction(uuid));
    }

    @GetMapping("/product/{name}")
    public List<Auction> searchByProductName(@PathVariable String name){
        return auctionService.searchByProductName(name);
    }

    @GetMapping("/owner/{name}")
    public List<Auction> searchByAuctionOwnerLastName(@PathVariable String name){
        return auctionService.searchByAuctionOwnerLastName(name);
    }

    @PostMapping("/test")
    public ResponseEntity<UUID> addTestAuction(){
        return ResponseEntity.ok(auctionService.createTestAuction());
    }

    @PostMapping("/new")
    public UUID addAuction(@RequestBody AuctionDTO auctionDTO){
        return auctionService.createNewAuction(auctionDTO);
    }
}

