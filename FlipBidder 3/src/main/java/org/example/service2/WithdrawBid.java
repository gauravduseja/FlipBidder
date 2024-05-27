package org.example.service2;

import org.example.helper.ValidationHelper;
import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class WithdrawBid implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();
        String buyerId = params.get(0);
        String auctionId  = params.get(1);

        ValidationHelper.validateRequest(buyerId, auctionId);
        BiddingRepo.BID_LIST.remove(buyerId);
    }
}
