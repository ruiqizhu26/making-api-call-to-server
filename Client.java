package seatgeek;
import java.util.*;
import java.time.LocalTime;

public class Client {
    Server server;
    String id;
    String dataEntry;

    public Client(Server server, String id) {
        server.addClient(id);
        this.server = server;
        this.id = id;
    }

    public void printClient() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", dataEntry: ");
        sb.append(dataEntry);
        System.out.println(sb.toString());
    }

    public void getDataEntry(int index) {
        dataEntry = this.server.getDataEntryWithId(id, index);
        System.out.println(dataEntry);
    }
}