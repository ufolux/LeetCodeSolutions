package Solutions.Graph.L210_CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 思路
 * 1. 计算每个节点的出度
 * 2. 寻找出度为 0 的节点，并将他们加入队列中
 * 3. 从队列中向结果数组中添加课程
 * 4. 添加课程之后，将所有指向该课程的节点出度减一
 * 5. 节点出度为 0 时，将该节点加入队列，并重复 3， 4， 5
 * 6. 队列为空时退出
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] lists = new ArrayList[numCourses];
        int[] points = new int[numCourses];

        for (int[] pair: prerequisites) {
            points[pair[0]]++;
            if (lists[pair[1]] == null) {
                lists[pair[1]] = new ArrayList<>();
            }
            lists[pair[1]].add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < points.length; i++) {
            if (points[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (size-- > 0) {
                Integer pre = queue.poll();
                res[idx++] = pre;
                List<Integer> list = lists[pre];
                if (list != null) {
                    for (Integer cls: list) {
                        points[cls]--;
                        if (points[cls] == 0) {
                            queue.add(cls);
                        }
                    }
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}
