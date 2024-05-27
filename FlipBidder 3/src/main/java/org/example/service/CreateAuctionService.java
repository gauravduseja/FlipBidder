package org.example.service;

import org.example.model.Auction;
import org.example.model.Bid;
import org.example.repository.BiddingRepo;

import java.util.*;
import java.util.stream.Collectors;

public class CreateAuctionService {

    public Auction createAuction(String id, int lowestBidLimit, int highestBidLimit, int participationCost, String seller) {
        Auction auction = new Auction(id, lowestBidLimit, highestBidLimit, participationCost, seller);
        BiddingRepo.AUCTION_LIST.put(id, auction);
        return auction;
    }

    public void addSeller(String name) {
        BiddingRepo.SELLER_LIST.add(name);
    }

    public void addBuyer(String name) {
        BiddingRepo.BUYER_LIST.add(name);
    }

    public String getWinner(String auctionId) {
        TreeMap<Double, List<String>> freqMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Bid> bid : BiddingRepo.BID_LIST.entrySet()) {
            if (bid.getValue().getAuctionId().equals(auctionId)) {
                List<String> buyers = new ArrayList<>();
                if (freqMap.containsKey(bid.getValue().getPrice())) {
                    buyers = freqMap.get(bid.getValue().getPrice());
                }
                buyers.add(bid.getValue().getId());
                freqMap.put(bid.getValue().getPrice(), buyers);
            }
        }

        for (Map.Entry<Double, List<String>> freq : freqMap.entrySet()) {
            if (freq.getValue().size() == 1) {
                return freq.getValue().get(0);
            }
        }

        return "NO_WINNER";
    }
}
