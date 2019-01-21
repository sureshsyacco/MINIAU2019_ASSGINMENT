package com.multithreading;
import java.util.LinkedList;
import java.util.ListIterator;
public class taxi {
	private passanger.DEST dest;
    private int passenger_count;
    public long time;
    public taxi() {
        System.out.println("New Taxi from taxi q:");
        passenger_count = 0;
    }
    
    public void setDestination(passanger.DEST dest) {
		this.dest = dest;
	}

	public passanger.DEST getDestination() {
        return dest;
    }

    public int getpassengerCount() {
        return passenger_count;
    }

    public boolean isFull() {
        if(passenger_count<4)
            return false;
        else
            return true;
    }
    public boolean isEmpty() {
        if(passenger_count==0)
            return true;
        else
            return false;
    }

    public boolean addPassenger() {
        if(isFull()){
            System.out.println("Taxi is ready to leave");
            return false;
        } else {
            passenger_count++;
            System.out.println("Passenger boards taxi to " + dest + "- number passengers " + passenger_count);
            return true;
        }
    }

    public boolean allocate_passenger(passanger p) {
        if(dest==null) {
            System.out.println("taxi is empty- set destination " + p.getDestination());
            dest = p.getDestination();
            return addPassenger();
        } else {
            if(dest==p.getDestination()){
                System.out.println("taxi available to " + dest);
                return addPassenger();
            } else {
                System.out.println("no taxi available");
                return false;
            }
        }
    }

}