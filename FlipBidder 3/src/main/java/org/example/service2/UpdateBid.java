package org.example.service2;

import org.example.helper.ValidationHelper;
import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class UpdateBid implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        String buyerId = params.get(0);
        String auctionId  = params.get(1);
        double price = Double.parseDouble(params.get(2));
        ValidationHelper.validateRequest(buyerId, auctionId);
        BiddingRepo.BID_LIST.get(buyerId).setAuctionId(auctionId).setPrice(price);
    }
}
