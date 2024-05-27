package org.example.model;

public class Bid {
    private final String id;
    private String auctionId;

    private double price;

    public Bid(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public Bid setAuctionId(String auctionId) {
        this.auctionId = auctionId;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Bid setPrice(double price) {
        this.price = price;
        return this;
    }
}
