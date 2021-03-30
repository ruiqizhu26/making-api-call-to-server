package seatgeek;
import java.util.*;
import java.time.*;

public class Server {
    List<String> data;
    Map<String, Map<LocalTime, Integer>> map;

    public Server() {
        data = new ArrayList<String>();
        map = new HashMap<>();
    }

    public void addDataEntry(String entry) {
        data.add(entry);
    }

    public void addClient(String id) {
        Map<LocalTime, Integer> client = new HashMap();
        client.put(null, 0);
        map.put(id, client);
    }

    public String getDataEntryWithId(String id, int index) {
        LocalTime currentLt = LocalTime.now();
        Map<LocalTime, Integer> client = map.get(id);
        LocalTime lastLt = null;
        Integer numRequest = null;
        for (LocalTime lt: client.keySet()) {
            lastLt = lt;
        }
        for (Integer i: client.values()) {
            numRequest = i;
        }
        if (lastLt != null) {
            Duration d = Duration.between(lastLt, currentLt);
            System.out.println(d.getSeconds());
            if (d.getSeconds() < 3 && numRequest == 3) return null;
            else if (d.getSeconds() < 3) client.put(lastLt, numRequest + 1);
            else {
                client.clear();
                client.put(currentLt, 1);
            }
        }
        else {
            client.clear();
            client.put(currentLt, 1);
        }
        return data.get(index);
    }
}