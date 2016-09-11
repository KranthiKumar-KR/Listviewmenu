package com.example.kranthi.listviewmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kranthi on 7/16/2016.
 */
public class DataProvider {
    public static HashMap<String, List<String>> getInfo(){
        HashMap<String, List<String>> DomainDetails = new HashMap<String, List<String>>();
        List<String> Social_Networks = new ArrayList<String>();
        Social_Networks.add("Google");
        Social_Networks.add("Facebook");
        Social_Networks.add("Twitter");
        Social_Networks.add("Instagram");
        Social_Networks.add("LinkedIn");
        List<String> Ride= new ArrayList<String>();
        Ride.add("Uber");
        Ride.add("Lyft");
        Ride.add("State Car");
        Ride.add("Car pool");
        List<String> Email= new ArrayList<String>();
        Email.add("Gmail");
        Email.add("Hotmail");
        Email.add("Outlook");
        Email.add("Yahoo");
        List<String> Sales= new ArrayList<String>();
        Sales.add("OfferUp");
        Sales.add("Wallapop");
        Sales.add("Letgo");
        Sales.add("Close5");
        DomainDetails.put("Social Networks", Social_Networks);
        DomainDetails.put("Sales", Sales);
        DomainDetails.put("Email", Email);
        DomainDetails.put("Ride", Ride);
        return DomainDetails;
    }
}
