package org.example.service2;

import org.example.CommandOperator;
import org.example.exception.InvalidInputException;
import org.example.helper.Constants;
import org.example.model.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandService {

    static CommandService commandService = null;

    public static CommandService getInstance(){
        if(commandService==null){
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws InvalidInputException {
        try {
            String[] commandWithArguments = input.split(" ");

            CommandOperator operator = CommandOperator.valueOf(commandWithArguments[0]);
            List<String> commandParams =
                    Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Command command = new Command(operator, commandParams);
            this.validateInputCommand(operator,command);
            return command;
        } catch (Exception e) {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void validateInputCommand(CommandOperator inputCommand , Command command) throws InvalidInputException {
        if(inputCommand.getNumberOfArguments()!=command.getCommandParams().size()){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
}
