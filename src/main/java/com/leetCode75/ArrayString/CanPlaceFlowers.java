//You have a long flowerbed in which some of the plots are planted,
//and some are not. However, flowers cannot be planted in adjacent plots.
//
//Given an integer array flowerbed containing 0's and 1's, where 0 means
//empty and 1 means not empty, and an integer n, return true if n new flowers can
//be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
//
//Example 1:
//Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
//
//Example 2:
//Input: flowerbed = [1,0,0,0,1], n = 2
//Output: false
//
//Constraints:
//1 <= flowerbed.length <= 2 * 104
//flowerbed[i] is 0 or 1.
//There are no two adjacent flowers in flowerbed.
//0 <= n <= flowerbed.length
package com.leetCode75.ArrayString;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowersV2(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowersV2(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowersV2(new int[]{0,0,0,0,0,1,0,0}, 0));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int[] flowerbedCopy = flowerbed.clone();
        int counter = 0;
        for (int i = 0; i < flowerbedCopy.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbedCopy[i - 1] == 0);
                boolean rightEmpty = (i == flowerbedCopy.length - 1) || (flowerbed[i + 1] == 0);
                if (leftEmpty && rightEmpty) {
                    flowerbedCopy[i] = 1;
                    counter++;
                }
            }
            if (counter == n){
                return true;
            }
        }
        return false;
    }

    public static boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        if (n == 0) return true;
        int counter = 0;
        boolean prevPlanted = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (!prevPlanted);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (leftEmpty && rightEmpty) {
                    counter++;
                }
                prevPlanted = leftEmpty && rightEmpty;
            } else {
                prevPlanted = true;
            }
            if (counter == n) {
                return true;
            }
        }
        return false;
    }
}

