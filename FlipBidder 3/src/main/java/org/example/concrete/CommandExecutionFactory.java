package org.example.concrete;

import org.example.model.Command;
import org.example.service2.*;

public class CommandExecutionFactory {

    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ADD_BUYER:
                    executor = new AddBuyer();
                    break;
                case ADD_SELLER:
                    executor = new AddSeller();
                    break;
                case CREATE_AUCTION:
                    executor = new CreateAuction();
                    break;
                case CREATE_BID:
                    executor = new CreateBid();
                    break;
                case UPDATE_BID:
                    executor = new UpdateBid();
                    break;
                case WITHDRAW_BID:
                    executor = new WithdrawBid();
                    break;
                case CLOSE_AUCTION:
                    executor = new CloseAuction();
                    break;

                default:
                    break;
            }
        }
        return executor;
    }
}
