import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gøran on 08.04.2015.
 */
public class FCFS implements DiskScheduler {

    int[] queue;
    int initialCylinder;

    public FCFS(int[] queue, int initialCylinder){
        this.queue = queue;
        this.initialCylinder = initialCylinder;
    }

    public int serviceRequests() {
        int headmovement = 0;
        return headmovement;
    }
}
