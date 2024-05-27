package org.example.service;

public interface BiddingService {

    String createBid(String buyerId, String auctionId, double price);

    String updateBid(String buyerId, String auctionId, double price);
}
