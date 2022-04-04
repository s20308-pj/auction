package pl.czaplinski.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czaplinski.model.Auction;

import pl.czaplinski.service.AuctionService;

import java.util.*;


@RestController
@RequestMapping("/auction")
public class auctionController {

    private final AuctionService auctionService;

    public auctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Auction>> getAuctions() {
        return ResponseEntity.ok(auctionService.getAuctions());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Auction> getAuction(@PathVariable UUID uuid) {
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
    public UUID addAuction(@RequestBody Auction auction){
        // nie mogę dać Auction bo UUID jest tworzony dopiero w swrwisie
        return auctionService.createNewAuction(auction);
    }
}

