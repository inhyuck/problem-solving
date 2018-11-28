/**
 * Date: 28/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 리모컨
 * description: 0-9 까지 숫자와 +,- 버튼 존재. 고장난 버튼과 원하는 채널이 주어졌을 때, 가장 짧게 버튼 눌러서 이동
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/1107
 */

package io.inhyuck.brute_force;

import java.util.*;

public class Q1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> availableButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            availableButtons.add(i);
        }
        for (int i = 0; i < m; i++) {
            availableButtons.remove(Integer.valueOf(scanner.nextInt()));
        }
//        System.out.printf("n = %d, m = %d, available buttons = %s", n, m, availableButtons.toString()); Input Log

        //숫자버튼만으로 이동했을 때 가장 가까운 숫자
        int proximateNumber = findProximateNumber(n, availableButtons);
        int minCount = Math.abs(n - proximateNumber) + String.valueOf(proximateNumber).length();

        System.out.println("proximateNumber : " + proximateNumber);
        System.out.println("minCount : " + minCount);

        System.out.println(Math.min(minCount, n - 100));
    }

    private static int findProximateNumber(int n, List<Integer> availableButtons) {
        String targetNumber = String.valueOf(n);
        StringBuilder proximateNumber = new StringBuilder();
        for (int i = 0; i < targetNumber.length(); i++) {
            int number = Character.getNumericValue(targetNumber.charAt(i));
            if (availableButtons.contains(number)) {
                proximateNumber.append(number);
                continue;
            }

            int restNumber = Integer.parseInt(String.valueOf(n).substring(i));
            int upNumber = computeUpNumber(number, availableButtons, targetNumber.length() - i); //target number보다 위로 큰 가까운 숫자
            int downNumber = computeDownNumber(number, availableButtons, targetNumber.length() - i); //target number 보다 아래로 작은 가까운 숫자
            if (upNumber - restNumber > restNumber - downNumber) {
                proximateNumber.append(upNumber);
                break;
            }
            proximateNumber.append(downNumber);
            break;
        }

        return Integer.parseInt(proximateNumber.toString());
    }

    private static int computeUpNumber(int number, List<Integer> availableButtons, int size) {
        int difference = 10;
        int upNumber = -1;
        for (int i : availableButtons) {
            if (i > number && (i - number) < difference) {
                upNumber = i;
                difference = i - number;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(upNumber);
        for (int i = 0; i < size - 1; i++) {
            result.append(availableButtons.get(0));
        }

        System.out.println("upNumber = " + result.toString());
        return Integer.parseInt(result.toString());
    }

    private static int computeDownNumber(int number, List<Integer> availableButtons, int size) {
        int difference = 10;
        int downNumber = -1;
        for (int i : availableButtons) {
            if (i < number && (number - i) < difference) {
                downNumber = i;
                difference = number - i;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(downNumber);
        for (int i = 0; i < size - 1; i++) {
            result.append(availableButtons.get(availableButtons.size() - 1));
        }

        System.out.println("downNumber = " + result.toString());
        return Integer.parseInt(result.toString());
    }
}
