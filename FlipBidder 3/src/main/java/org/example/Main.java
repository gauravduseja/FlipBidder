package org.example;

import org.example.concrete.FlipBidderSystem;
import org.example.exception.InvalidInputException;
import org.example.model.Command;
import org.example.service.BiddingServiceImpl;
import org.example.service.CreateAuctionService;
import org.example.service2.FileProcessorService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // please give input from here as of now (service 2 package is there to handle the input from text file but its incomplete)
//        BiddingServiceImpl biddingServiceImpl = new BiddingServiceImpl();
//        CreateAuctionService createAuctionService = new CreateAuctionService();
//
//        createAuctionService.addBuyer("buyer1");
//        createAuctionService.addBuyer("buyer2");
//        createAuctionService.addBuyer("buyer3");
//
//        createAuctionService.addSeller("seller1");
//
//        createAuctionService.createAuction("A2", 5, 20, 2, "seller2");
//
//        biddingServiceImpl.createBid("buyer1", "A2", 17);
//        biddingServiceImpl.createBid("buyer2", "A2", 15);
//        biddingServiceImpl.updateBid("buyer2", "A2", 19);
//        biddingServiceImpl.createBid("buyer3", "A2", 19);
//
//
//        System.out.println(createAuctionService.getWinner("A2"));

        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                FlipBidderSystem flipBidderSystem = new FlipBidderSystem();
                FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
                try {
                    try {
                        Command command = fileProcessorService.processLine();
                        while (command != null) {
                            flipBidderSystem.fulfillCommand(command);
                            command = fileProcessorService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}