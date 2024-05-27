package org.example.service2;

import org.example.model.Bid;
import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.*;

public class CloseAuction implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        TreeMap<Double, List<String>> freqMap = new TreeMap<>(Collections.reverseOrder());
        String auctionId = command.getCommandParams().get(0);
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
                System.out.println("winner is " + freq.getValue().get(0));
                return;
            }
        }

        System.out.println("NO_WINNER");
    }
}
