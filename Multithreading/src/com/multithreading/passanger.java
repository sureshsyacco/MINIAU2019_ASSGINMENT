package com.multithreading;
import java.util.LinkedList;
import java.util.ListIterator;

public class passanger {
	 public static enum DEST {
	        Electronic_city,Banashankari,Whitefield,Yalahanka,Banneragatta
	    }
	    public static final DEST[] DEST_VALUES = DEST.values();


	    private DEST destination;

	    public passanger(DEST dest){
	        destination = dest;
	    }
	    public DEST getDestination() {
	        return destination;
	    }

}
