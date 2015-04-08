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
        int prev = initialCylinder;
        boolean init = false;
        for(int i : queue){
            if(!init) { headmovement += Math.abs(queue[i]-prev); init = true;}
            if(init) {
                headmovement += Math.abs(queue[i-1]-queue[i]);
            }
            System.out.println("H: " + headmovement);
        }
        return headmovement;
    }
}
