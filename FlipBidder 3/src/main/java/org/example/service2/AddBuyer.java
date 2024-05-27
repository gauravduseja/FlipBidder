package org.example.service2;

import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class AddBuyer implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        String buyerName = params.get(0);
        BiddingRepo.BUYER_LIST.add(buyerName);
    }
}
