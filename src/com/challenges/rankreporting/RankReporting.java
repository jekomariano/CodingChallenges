package challenges.rankreporting;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RankReporting {

    public static void main(String[] args) {

        int[] high = new int[] { 3, 4, 3, 0, 2, 2, 3, 0, 0};
        System.out.println(findNumberofReporting(high));

        int[] otherRanks = new int[] { 4, 2, 0};
        System.out.println(findNumberofReporting(otherRanks));

        int[] newRanks = new int[] { 4, 4,3,3, 1, 0};
        System.out.println(findNumberofReporting(newRanks));
    }

    public static int findNumberofReporting(int[] ranks) {
        HashMap<Integer, Integer> rankNumbers = new HashMap<>();
        AtomicInteger result = new AtomicInteger();
        for (int rank : ranks) {
            if (rankNumbers.containsKey(rank)) {
                Integer count = rankNumbers.get(rank) + 1;
                rankNumbers.put(rank, count);
            } else {
                rankNumbers.put(rank, 1);
            }
        }

        rankNumbers.forEach((key, value) -> {
            int higherRank = key + 1;
                if (rankNumbers.containsKey(higherRank)) {
                    result.addAndGet(value);
                }
        });
        System.out.println(rankNumbers);
        return result.get();
    }

}
