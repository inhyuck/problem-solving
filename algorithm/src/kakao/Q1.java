/**
 * Date: 2018. 9. 15.
 * Author: inhyuck | https://github.com/inhyuck
 * Title: 2019 카카오 신입채용 1차 코딩테스트 문제 1
 * 모든 케이스 통과
 */
package kakao;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        String[] strings = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = Solution.solution(strings);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public static String[] solution(String[] record) {
            ArrayList<String> result = new ArrayList<>();
            List<Node> list = new ArrayList<>();
            Map<String, String> map = new HashMap<>();
            int t = record.length;
            for (int i = 0; i < record.length; i++) {
                String[] strings = record[i].split(" ");
                switch (strings[0]) {
                    case "Enter":
                        list.add(new Node(strings[1], strings[0]));
                        map.put(strings[1], strings[2]);
                        break;
                    case "Leave":
                        list.add(new Node(strings[1], strings[0]));
                        break;
                    case "Change":
                        map.put(strings[1], strings[2]);
                        break;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                String username = map.get(list.get(i).uid);
                String method = list.get(i).method;
                if (method.equals("Enter")) {
                    result.add(username+ "님이 들어왔습니다.");
                } else {
                    result.add(username + "님이 나갔습니다.");
                }

            }
            String[] result2 = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                result2[i] = result.get(i);
            }
            return result2;
        }

        static class Node {
            String uid;
            String method;

            public Node(String uid, String method) {
                this.uid = uid;
                this.method = method;
            }
        }
    }
}
