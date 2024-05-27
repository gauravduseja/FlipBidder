package org.example.repository;

import org.example.model.Auction;
import org.example.model.Bid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BiddingRepo {

    public static HashMap<String, Auction> AUCTION_LIST = new HashMap<>();
    public static List<String> SELLER_LIST = new ArrayList<>();
    public static List<String> BUYER_LIST = new ArrayList<>();

    public static HashMap<String, Bid> BID_LIST = new HashMap<>();
}
