package org.example.helper;

import org.example.exception.AuctionNotFoundException;
import org.example.exception.UserNotFoundException;
import org.example.repository.BiddingRepo;

public class ValidationHelper {

    public static void validateRequest(String buyerId, String auctionId) {
        if (!BiddingRepo.BUYER_LIST.contains(buyerId)) {
            throw new UserNotFoundException("USER_NOT_FOUND");
        }

        if (!BiddingRepo.AUCTION_LIST.containsKey(auctionId)) {
            throw new AuctionNotFoundException("AUCTION_NOT_FOUND");
        }
    }
}
