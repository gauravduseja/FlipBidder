package org.example.service2;

import org.example.model.Command;
import org.example.repository.BiddingRepo;

import java.util.List;

public class AddSeller implements CommandExecutor{
    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        String sellerName = params.get(0);
        BiddingRepo.SELLER_LIST.add(sellerName);
    }
}
