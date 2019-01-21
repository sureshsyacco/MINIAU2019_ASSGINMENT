package com.multithreading;

import java.util.LinkedList;

import java.util.ListIterator;
import java.util.Random;

public class passangerQ implements Runnable {
    taxi_stand taxi_lot;
    LinkedList<passanger> passenger_q;
    int qNumber=0;
    public passangerQ(LinkedList<passanger> queue, taxi_stand l) {
        passenger_q = queue;
        taxi_lot = l;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {

            }
            int pick = new Random().nextInt(passanger.DEST.values().length);
            passanger p = new passanger(passanger.DEST_VALUES[pick]);
            System.out.println("New passenger with to " + 
            p.getDestination() + " arrives.");
            
            boolean k=taxi_lot.allocatePassenger(p);
            if(!k) {
                System.out.println("all cabs are occupied. Adding passanget to Queue..");
                passenger_q.add(p);
               }
        }
    }
}