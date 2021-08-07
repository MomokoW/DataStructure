package inteview.concurrent.aiqiyi;

import java.util.*;

/**
 * Created by momoko on 2021/8/1.
 * 湖泊抽水问题
 */
public class Lake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String arrString = input.substring(1, input.length() - 1);
//        System.out.println(arrString);
        String[] arrStr = arrString.split(",");
        int N = arrStr.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        // 接下来求解返回的数组
        int[] res = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                if (set.contains(nums[i])) {
                    res = new int[0];
                    break;
                } else {
                    res[i] = -1;
                    set.add(nums[i]);
                }
            } else {
                // 当前可以抽干湖水时，开始搜索接下来可能会下雨且已经有水的湖泊，选择将其抽干
                // 如果接下来都没有湖泊可以抽，就选择第一个下雨的湖泊
                int target = -1;
                for (int j = i + 1; j < N; j++) {
                    if (nums[j] > 0 && set.contains(nums[j])) {
                        set.remove(nums[j]);
                        target = j;
                        break;
                    }
                }
                if (target == -1) {
                    res[i] = 1;
                } else {
                    res[i] = nums[target];
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
