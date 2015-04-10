class SSTF implements DiskScheduler{
    int[] queue;
    int startPos;

    public SSTF(int[] queue, int startPos){
        this.queue = queue;
        this.startPos = startPos;
    }

    public int serviceRequests(){
        int headMovement = 0;
        int prev = startPos;
        int [] rpath = path();
        for (int i=0; i < rpath.length; i++) {
            headMovement += Math.abs(rpath[i]-prev);
            prev = rpath[i];
        }
        return headMovement;
    }

    public int[] path(){
        int [] resultPath = new int[queue.length];
        int now = startPos;
        int [] requests = new int[queue.length];
        for (int i = 0; i < queue.length; i++){
            requests[i] = queue[i];
        }
        for (int i = 0; i < resultPath.length; i++){
            int closest = closest(now, requests);
            resultPath[i] = closest;
            now = closest;
        }
        return resultPath;
    }

    int closest(int k, int[] requests){
        int min = 5000000;
        int minPos = -1;
        for (int i = 0; i < requests.length; i++){
            if (requests[i] == -1) continue;
            else if  (Math.abs(k-queue[i]) < min) {
                minPos = i;
                min = Math.abs(k-queue[i++]);
            }
        }
        int nearestCylinder = requests[minPos];
        requests[minPos] = -1;
        return nearestCylinder;
    }

    public void println(){
        System.out.println("SSTF head movement = " + serviceRequests());

        System.out.print("SSTF Path = ");
        for(int i: path()){
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public int[] returnPath(){
        int[] path = path();
        return path;
    }
}
