
public class FCFS{

    int[] queue;
    int startPos;
    boolean init = false;

    public FCFS(int[] queue, int startPos) {
        this.queue = queue;
        this.startPos = startPos;
    }

    public int serviceRequests() {
        int headMovement = 0;
        int prev = startPos;
        for (int i = 0; i < queue.length; i++) {
            if (init) {
                headMovement += Math.abs(queue[i - 1] - queue[i]);
            }
            if (!init) {
                headMovement += Math.abs(queue[i] - prev);
                init = true;
            }
        }
        return headMovement;
    }

    public int[] returnPath(){
        return queue;
    }
}
