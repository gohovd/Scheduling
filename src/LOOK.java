import java.util.*;

public class LOOK implements DiskScheduler {
    TreeMap<Integer, Integer> refStr;
    int start;

    public LOOK(int[] refStr, int start) {
        this.refStr = new TreeMap<Integer, Integer>();
        for (int aRefStr : refStr) {
            this.refStr.put(aRefStr, aRefStr);
        }
        this.refStr.put(start, start);
        this.start = start;
    }

    @Override
    public int serviceRequests() {
        int head = start;
        int total = 0;

        SortedMap<Integer, Integer> lesser = refStr.headMap(start, false);
        SortedMap<Integer, Integer> greater = refStr.tailMap(start, false);

        int next;

        if (lesser.size() < greater.size()) {

            while (!lesser.isEmpty()) {

                next = lesser.lastKey();
                total += Math.abs(head - next);
                head = next;
                lesser.remove(next);
            }

            while (!greater.isEmpty()) {

                next = greater.firstKey();
                total += Math.abs(head - next);
                head = next;
                greater.remove(next);
            }
        } else {

            while (!greater.isEmpty()) {

                next = greater.firstKey();
                total += Math.abs(head - next);
                head = next;
                greater.remove(next);
            }

            while (!lesser.isEmpty()) {

                next = lesser.lastKey();
                total += Math.abs(head - next);
                head = next;
                lesser.remove(next);
            }
        }

        return total;
    }
}