package org.example.model;

public class Auction {

    private final String id;
    private final double lowestBidLimit;
    private final double highestBidLimit;
    private final double participationCost;
    private final String seller;

    public Auction(String id, double lowestBidLimit, double highestBidLimit, double participationCost, String seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
    }

    public String getId() {
        return id;
    }

    public double getLowestBidLimit() {
        return lowestBidLimit;
    }

    public double getHighestBidLimit() {
        return highestBidLimit;
    }

    public double getParticipationCost() {
        return participationCost;
    }

    public String getSeller() {
        return seller;
    }
}
