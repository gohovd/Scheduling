import java.util.ArrayList;
import java.util.Scanner;

public class FCFS implements DiskScheduler {

    int[] queue;
    int initialCylinder;
    boolean init = false;

    public FCFS(int[] queue, int initialCylinder) {
        this.queue = queue;
        this.initialCylinder = initialCylinder;
    }

    public int serviceRequests() {
        int headmovement = 0;
        int prev = initialCylinder;
        for (int i = 0; i < queue.length; i++) {
            if (init) {
                headmovement += Math.abs(queue[i - 1] - queue[i]);
            }
            if (!init) {
                headmovement += Math.abs(queue[i] - prev);
                init = true;
            }
        }
        return headmovement;
    }
}
