package org.example.service2;

import org.example.model.Auction;
import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class CreateAuction implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        String id = params.get(0);
        double lowestBidLimit = Double.parseDouble(params.get(1));
        double highestBidLimit = Double.parseDouble(params.get(2));
        double participationCost = Double.parseDouble(params.get(3));
        String seller = params.get(4);

        Auction auction = new Auction(id, lowestBidLimit, highestBidLimit, participationCost, seller);
        BiddingRepo.AUCTION_LIST.put(id, auction);
    }
}
