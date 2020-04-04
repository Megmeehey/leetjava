package main;

import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final int[] nums = {0, 1, -3, 0, -1, 0, 1, -5, 4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        int i = 0;
        while (i < nums.length - j) {
            if (nums[i + j] == 0) {
                j++;
            } else {
                nums[i] = nums[i + j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static boolean isHappy(int n) {
        int nn;
        int digit;

        while (n != 1 && n != 7) {
            if (n < 10)
                return false;
            nn = 0;
            while (n != 0) {
                digit = n % 10;
                nn += digit * digit;
                n /= 10;
            }
            n = nn;
        }

        return true;
    }

    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    private static String reversePlease(String toBeReversed) {
        char[] charArrayToBeReversed = toBeReversed.toCharArray();

        char tmp;

        for (int j = 0; j < charArrayToBeReversed.length / 2; j++) {
            tmp = charArrayToBeReversed[j];
            charArrayToBeReversed[j] = charArrayToBeReversed[charArrayToBeReversed.length - j - 1];
            charArrayToBeReversed[charArrayToBeReversed.length - j - 1] = tmp;
        }

        return new String(charArrayToBeReversed);
    }

    private static Integer convertPlease(String input, Map<String, Integer> conversionMap) {
        int result = 0;

        int currentSymbol = 0;
        while (currentSymbol < input.length()) {
            if (currentSymbol + 2 <= input.length()) {
                Integer probablyValueRomanSymbol = conversionMap.get(input.substring(currentSymbol, currentSymbol + 2));
                if (probablyValueRomanSymbol != null) {
                    result += probablyValueRomanSymbol;
                    currentSymbol += 2;
                    continue;
                }
            }
            result += conversionMap.get(input.substring(currentSymbol, currentSymbol + 1));
            currentSymbol++;
        }

        return result;
    }
}
