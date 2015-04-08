import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gøran on 08.04.2015.
 */
public class Runnable {

    static FCFS fcfs;
    static SSTF sstf;
    static final int initialCylinder = 110; //starting position(?)


    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        boolean ack = false;
        String x;
        ArrayList<Integer> ref = new ArrayList();
        while (!ack) {
            System.out.println("Please follow the instructions in the console. \n" +
                    "Text providing instructions will have a percentage symbol prefix. \n");
            System.out.println("% Enter a reference string containing the pages for the simulation. \n" +
                    "% Example reference (corr. syntax): 50 10 39 42 11 24 30. \n" +
                    "% The headspace for FCFS, SSTF, SCAN and LOOK will be returned. \n" +
                    "% Along with the sequence of operations for each scheduling algorithm.");
            x = userInput.nextLine();
            if (x.isEmpty()) {
                System.out.println("% The input string cannot be empty.");
            } else if (!x.isEmpty()) {
                String[] split = x.split(" ");
                for (String s : split) {
                    int sint = Integer.parseInt(s);
                    ref.add(sint);
                }
                ack = true;
            }
        }
        //here we pass the array of integers to the various scheduling algorithms..

    }
}
