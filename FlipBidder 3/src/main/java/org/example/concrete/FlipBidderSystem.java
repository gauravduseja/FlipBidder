package org.example.concrete;

import org.example.exception.InvalidInputException;
import org.example.model.Command;
import org.example.service2.CommandExecutor;

public class FlipBidderSystem {

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        commandExecutor.executeCommand(inputCommand);
    }
}
