import java.io.IOException;

/**
 * Created by Gøran on 08.04.2015.
 */
public class Runnable {

    static FCFS f = new FCFS();

    public static void main(String[] args) throws IOException {
        f.serviceRequests();
    }
}
