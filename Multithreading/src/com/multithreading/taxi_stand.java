package com.multithreading;

import java.util.LinkedList;
import java.util.ListIterator;

public class taxi_stand {
	private int size = 4;
	private LinkedList<taxi> taxi_stand_list;
	
	private LinkedList<taxi> taxi_q;
	private LinkedList<passanger> passenger_q;

	public taxi_stand(int capacity, LinkedList<taxi> q, LinkedList<passanger> pq) {
		size = capacity;
		taxi_q = q;
		passenger_q = pq;
		taxi_stand_list = new LinkedList<taxi>();
		for (int i = 0; i < size; i++) {
			taxi_stand_list.add(new taxi());
		}
		System.out.println("Creating a TaxiStand with capacity " + 4);
	}

	public boolean addTaxi(taxi c) {
		if (!isFull() || isEmpty()) {

			taxi_stand_list.add(c);
			return true;
		}
		return false;
	}

	public boolean isFull() {
		return (taxi_stand_list.size() < size) ? false : true;
	}

	public boolean isEmpty() {
		return (taxi_stand_list.size() == 0) ? true : false;
	}

	public boolean allocatePassenger(passanger p) {
		boolean u = false;
		for (taxi q : taxi_stand_list) {
			if (q.getDestination() == null) {
				q.setDestination(p.getDestination());
				u = q.addPassenger();
			}

			else if (q.getDestination() == p.getDestination()) {
				System.out.println("Found taxi to " + p.getDestination());
				u = q.addPassenger();
			}

		}
		return u;
	}

	public synchronized void processPassengerQueue() {
		System.out.println("Starting to process passengerQueue with " + passenger_q.size() + " passengers");
		for (passanger i : passenger_q) {
			if (this.allocatePassenger(i))
				;
			{
				passenger_q.remove(i);
				System.out.println("One of them in queue is procseesed");
			}
		}

		System.out.println("After processing passengerQueue " + passenger_q.size() + " passengers remain in queue");

	}

	public synchronized void processTaxiStandQueue() {

		ListIterator<taxi> standIterator = taxi_stand_list.listIterator();

		while (standIterator.hasNext()) {

			taxi taxi = standIterator.next();

			long finish = System.currentTimeMillis();

			long timeElapsed = finish - taxi.time;

			if (taxi.getpassengerCount() == 4 || (!(taxi.isEmpty()) && ((timeElapsed) > 50000))) {

				System.out.println("Taxi to " + taxi.getDestination() + " departs");

				taxi_stand_list.remove(taxi);

			}

		}

	}

	public void printStatus() {
		ListIterator<taxi> standIterator = taxi_stand_list.listIterator();
		int position = 0;
		while (standIterator.hasNext()) {
			taxi taxi = standIterator.next();
			position++;
			System.out.println(
					position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
		}
	}

	public static void main(String[] args) {
		System.out.println("-----------------starting taxi serive------------------");
		LinkedList<taxi> taxi_q = new LinkedList<taxi>();
		LinkedList<passanger> passenger_q = new LinkedList<passanger>();
		taxi_stand taxi_lot = new taxi_stand(5, taxi_q, passenger_q);

		TaxiQ taxicreator = new TaxiQ(taxi_q, taxi_lot);
		passangerQ passengerCreator = new passangerQ(passenger_q, taxi_lot);
		Thread T2 = new Thread(taxicreator);
		Thread T1 = new Thread(passengerCreator);
		T1.start();
		synchronized (T1) {
			try {
				System.out.println("Waiting in a queue...");
				T1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			taxi_lot.processPassengerQueue();
			T2.start();
			taxi_lot.processTaxiStandQueue();
			T2.notifyAll();
			taxi_lot.printStatus();

		}
	}
}
