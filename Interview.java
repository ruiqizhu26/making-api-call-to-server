package seatgeek;
import java.util.*;
import seatgeek.*;

public class Interview {
    public static void main(String[] args) {
        Server server = new Server();
        Client client1 = new Client(server, "#1");
        Client client2 = new Client(server, "#2");
        server.addDataEntry("a");
        server.addDataEntry("b");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                for (int j = 0; j < 5; j++) {
                    client1.getDataEntry(0);
                }
            }
            catch (Exception e) {
                System.out.println("Error in Interview");
            }
        }
    }
}