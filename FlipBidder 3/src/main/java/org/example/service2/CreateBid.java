package org.example.service2;

import org.example.helper.ValidationHelper;
import org.example.model.Auction;
import org.example.model.Bid;
import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class CreateBid implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        String buyerId = params.get(0);
        String auctionId  = params.get(1);
        double price = Double.parseDouble(params.get(2));

        ValidationHelper.validateRequest(buyerId, auctionId);
        Auction auction = BiddingRepo.AUCTION_LIST.get(auctionId);
        if (price >= auction.getLowestBidLimit() && price <= auction.getHighestBidLimit()) {
            Bid bid = new Bid(buyerId).setAuctionId(auctionId).setPrice(price);
            BiddingRepo.BID_LIST.put(buyerId, bid);
        }
    }
}
