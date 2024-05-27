package org.example;

public enum CommandOperator {

    ADD_BUYER(1),
    ADD_SELLER(1),
    CREATE_AUCTION(5),
    CREATE_BID(3),
    UPDATE_BID(3),
    WITHDRAW_BID(2),
    CLOSE_AUCTION(1);

    CommandOperator(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}
