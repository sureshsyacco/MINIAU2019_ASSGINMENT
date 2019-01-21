package com.multithreading;
import java.util.LinkedList;

import java.util.ListIterator;

public class TaxiQ implements Runnable {

    private LinkedList<taxi> taxi_q;
    private taxi_stand taxi_stand_list;

    public TaxiQ(LinkedList<taxi> q, taxi_stand l){
        taxi_q = q;
        taxi_stand_list = l;
    }

    @Override
    public void run() {
        System.out.println("Threads starting");
        while(true) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ie) {

            }
            
            taxi T=new taxi();
            T.time=System.currentTimeMillis();
            taxi_q.add(T);
            if(taxi_stand_list.addTaxi(taxi_q.getFirst()));
            		taxi_q.removeFirst();
            	
            
            
        }
    }
}