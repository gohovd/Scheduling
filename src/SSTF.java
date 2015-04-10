class SSTF{
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
        for (int aRpath : rpath) {
            headMovement += Math.abs(aRpath - prev);
            prev = aRpath;
        }
        return headMovement;
    }

    public int[] path(){
        int [] resultPath = new int[queue.length];
        int now = startPos;
        int [] requests = new int[queue.length];
        System.arraycopy(queue, 0, requests, 0, queue.length);
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
        for (int i = 0; i < requests.length; i++) {
            if (requests[i] == -1) {
            } else if (Math.abs(k - queue[i]) < min) {
                minPos = i;
                min = Math.abs(k - queue[i++]);
            }
        }
        int nearestCylinder = requests[minPos];
        requests[minPos] = -1;
        return nearestCylinder;
    }

    public int[] returnPath(){
        return path();
    }
}
