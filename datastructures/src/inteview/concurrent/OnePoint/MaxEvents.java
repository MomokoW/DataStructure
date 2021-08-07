package inteview.concurrent.OnePoint;

import com.momoko.heap.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by momoko on 2021/7/30.
 */
public class MaxEvents {

    public int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        int M = timeSchedule.size();
        if (M == 0) {
            return 0;
        }
        // 分别表示开始时间和结束时间，用分钟表示
        int[][] events = new int[M][2];
        for (int i = 0; i < M; i++) {
            // 把每对时间表示为分钟
            events[i][0] = parseHour2Minute(timeSchedule.get(i).get(0));
            events[i][1] = parseHour2Minute(timeSchedule.get(i).get(1));
        }
        return maxEvents(events);
    }

    // 把小时表示的时间转换为分钟
    public int parseHour2Minute(String str) {
        String[] strs = str.split(":");
        int res = 0;
        int hour = Integer.parseInt(strs[0]);
        int minute = Integer.parseInt(strs[1]);
        res += 60 * hour + minute;
        return res;
    }

    public int maxEvents(int[][] events) {
        // 按照最早开始的时间进行排序，最早开始时间相同就按照最早结束时间排序
        Set<Integer> set = new HashSet<>();
        Arrays.sort(events, (first, second) -> first[0] == second[0] ? first[1] - second[1] : first[0] - second[0]);
        int end = events[0][1];
        int i = 1;
        int count = 1;
        while (i < events.length) {
            if (events[i][0] >= end) {
                count++;
                end = events[i][1];
            }
            i++;
        }
        return count;
    }

    //[["10:00","12:00"],["03:00","11:30"],["11:30","14:00"]]
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("10:00");
        list1.add("12:00");
        list.add(list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("03:00");
        list2.add("11:30");
        list.add(list2);
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("11:30");
        list3.add("14:00");
        list.add(list3);

        MaxEvents maxEvents = new MaxEvents();
        int num = maxEvents.countMaxActivity(list);
        System.out.println(num);

    }
}
