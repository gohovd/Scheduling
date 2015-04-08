import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gøran on 08.04.2015.
 */
public class FCFS implements DiskScheduler {

    /**
     * The first-come first-server scheduling algorithm.
     * SO EASY SO WOW MUCH GREAT
     */
    public FCFS() {

    }

    public void fcfs() {

    }

    public int serviceRequests() {
        Scanner userInput = new Scanner(System.in);
        boolean ack = false;
        String x;
        ArrayList<String> ref = new ArrayList();
        while (!ack) {
            System.out.println("Please follow the instructions in the console. \n" +
                    "Text providing instructions will have a percentage symbol prefix. \n");
            System.out.println("% Enter a reference string containing the pages for the simulation. \n" +
                    "% Example reference (corr. syntax): 7 0 1 2 0 2 0 4 2 3 0 3 2 1 2 0 1 7 0 1");
            x = userInput.nextLine();
            if (x.isEmpty()) {
                System.out.println("% The input string cannot be empty.");
            } else if (!x.isEmpty()) {
                String[] split = x.split(" ");
                int no = 1;
                for (String s : split) {
                    ref.add(s);
                    System.out.println(no + s);
                }
                ack = true;
            }
        }
        return ref.size();
    }
}
