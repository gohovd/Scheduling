import java.util.*;

public class SCAN implements DiskScheduler {
    TreeMap<Integer, Integer> refStr;
    int start;
    int max;

    public SCAN(int[] refStr, int start, int max) {
        this.refStr = new TreeMap<Integer, Integer>();
        for (int aRefStr : refStr) {
            this.refStr.put(aRefStr, aRefStr);
        }
        this.refStr.put(start, start);
        this.start = start;
        this.max = max;
    }

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

            total += Math.abs(head);
            head = 0;

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

            total += Math.abs(head - max);
            head = max;

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