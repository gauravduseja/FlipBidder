package org.example.service;

import org.example.exception.AuctionNotFoundException;
import org.example.exception.UserNotFoundException;
import org.example.model.Auction;
import org.example.model.Bid;
import org.example.repository.BiddingRepo;

public class BiddingServiceImpl implements BiddingService {

    @Override
    public String createBid(String buyerId, String auctionId, double price) {
        validateRequest(buyerId, auctionId);
        Auction auction = BiddingRepo.AUCTION_LIST.get(auctionId);
        if (price >= auction.getLowestBidLimit() && price <= auction.getHighestBidLimit()) {
            Bid bid = new Bid(buyerId).setAuctionId(auctionId).setPrice(price);
            BiddingRepo.BID_LIST.put(buyerId, bid);
        }
        return "Bid is successfully created with buyer id: {0} with price: {1}";
    }

    @Override
    public String updateBid(String buyerId, String auctionId, double price) {
        validateRequest(buyerId, auctionId);
        BiddingRepo.BID_LIST.get(buyerId).setAuctionId(auctionId).setPrice(price);
        return "Bid is successfully updated";
    }

    public void withDrawBid(String buyerId, String auctionId) {
        validateRequest(buyerId, auctionId);
        BiddingRepo.BID_LIST.remove(buyerId);
    }

    private void validateRequest(String buyerId, String auctionId) {
        if (!BiddingRepo.BUYER_LIST.contains(buyerId)) {
            throw new UserNotFoundException("USER_NOT_FOUND");
        }

        if (!BiddingRepo.AUCTION_LIST.containsKey(auctionId)) {
            throw new AuctionNotFoundException("AUCTION_NOT_FOUND");
        }
    }
}
