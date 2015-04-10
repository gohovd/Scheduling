import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runnable {

    static FCFS fcfs;
    static SSTF sstf;
    static SCAN scan;
    static LOOK look;
    static int headstart = 0; //starting position(?)
    static int[] ref;


    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        boolean ack = false;
        String x;
        while (!ack) {
            System.out.println("Please follow the instructions in the console. \n" +
                    "Text providing instructions will have a percentage symbol prefix. \n");
            System.out.println("% Enter a reference string for the simulation. \n" +
                    "% Example reference (corr. syntax): 50,10,39,42,11,24,30. \n" +
                    "% The headspace for FCFS, SSTF, SCAN and LOOK will be returned. \n" +
                    "% Along with the sequence of operations almost every scheduling algorithm.");
            x = userInput.nextLine();
            if (x.isEmpty()) {
                System.out.println("% The input string cannot be empty.");
            } else if (!x.isEmpty()) {
                int no = 0;
                String[] split = x.split(",");
                ref = new int[split.length];
                for (String s : split) {
                    int sint = Integer.parseInt(s);
                    ref[no] = sint;
                    headstart = ref[0];
                    no++;
                }
                ack = true;
            }
        }
        System.out.println("IC: " + headstart);
        //here we pass the array of integers to the various scheduling algorithms..
        sstf = new SSTF(ref, headstart);
        System.out.println("SSTF headspace: " + sstf.serviceRequests());
        System.out.print("SSTF path: ");
        for(int i : sstf.returnPath()){
            System.out.print(i + " ");
        }
        //change line..
        System.out.println("\n");

        fcfs = new FCFS(ref, headstart);
        System.out.println("FCFS headspace: " + fcfs.serviceRequests());
        System.out.print("FCFS path: ");
        for(int i : fcfs.returnPath()) {
            System.out.print(i + " ");
        }
        //change line..
        System.out.println("\n");

        //collect highest value from array, to pass to class SCAN
        int max = 0;
        for(int i : ref){
            if(i > max){
                max = i;
            }
        }
        scan = new SCAN(ref, headstart, 1000);
        System.out.println("SCAN headspace: " + scan.serviceRequests());

        //System.out.println("\n");

        look = new LOOK(ref, headstart);
        System.out.println("LOOK headspace: " + look.serviceRequests());
    }
}
