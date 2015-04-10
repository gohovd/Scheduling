import java.io.IOException;

import java.util.Scanner;

public class Runnable {

    static FCFS fcfs;
    static SSTF sstf;
    static SCAN scan;
    static LOOK look;
    static int headstart;
    static int[] ref;


    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);
        boolean ack = false;
        String x;
        while (!ack) {
            System.out.println((char)27 + "[34mEnter a queue, example: 3,20,1,50,30" + (char)27 + "[0m");
            System.out.println((char)27 + "[34mThe first number in the queue will be the head start position" + (char)27 + "[0m");

            x = userInput.nextLine();
            if (x.isEmpty()) {
                System.out.println("Input can not be empty.");
            } else {
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

        System.out.println("Head start position: " + headstart + "\n");

        sstf = new SSTF(ref, headstart);
        System.out.println("SSTF total head movement: " + sstf.serviceRequests());
        System.out.print("SSTF path: ");
        for(int i : sstf.returnPath()){
            System.out.print(i + " ");
        }

        System.out.println("\n");

        fcfs = new FCFS(ref, headstart);
        System.out.println("FCFS total head movement: " + fcfs.serviceRequests());
        System.out.print("FCFS path: ");
        for(int i : fcfs.returnPath()) {
            System.out.print(i + " ");
        }

        System.out.println("\n");

        int max = 0;
        for(int i : ref){
            if(i > max){
                max = i;
            }
        }
        scan = new SCAN(ref, headstart, 1000);
        System.out.println("SCAN total head movement: " + scan.serviceRequests());
        System.out.println((char)27 + "[31mSCAN path not yet functional" + (char)27 + "[0m");

        System.out.println("\n");

        look = new LOOK(ref, headstart);
        System.out.println("LOOK total head movement: " + look.serviceRequests());
        System.out.println((char)27 + "[31mLOOK path not yet functional" + (char)27 + "[0m");
    }
}
