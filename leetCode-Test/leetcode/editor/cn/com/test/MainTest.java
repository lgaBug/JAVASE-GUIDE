package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MainTest {

    public static void main(String[] args) {

        String numStr = "1 ";
        long numLong = Long.parseLong(numStr.trim());
        System.out.println("numLong = " + numLong);

    }

    public  static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String tempStr = strs[0];
        if(strs.length == 1){
            return tempStr;
        }
        while (tempStr.length() > 0) {
            for (int i = 1; i < strs.length; i++) {
                if (i == strs.length - 1 && strs[i].startsWith(tempStr)) {
                    if (i == strs.length - 1) {
                        return tempStr;
                    }
                }else{
                    tempStr = tempStr.substring(0, tempStr.length() - 1);
                    break;
                }
            }
        }
        return tempStr;
    }

        //public  static String longestCommonPrefix(String[] strs) {
    //    int endIndex = 0;
    //    if (strs == null || strs.length == 0) {
    //        return "";
    //    }
    //    String firstStr = strs[0];
    //    for (int i = 0; i < firstStr.length(); i++) {
    //
    //        for (int j = 1; j < strs.length; j++) {
    //
    //            if (firstStr.charAt(i) == strs[j].charAt(i)) {
    //                endIndex = i;
    //            }else{
    //                return firstStr.substring(0, endIndex);
    //            }
    //        }
    //
    //    }
    //
    //    return firstStr;
    //}

    //public static String intToRoman(int num) {
    //
    //    StringBuilder resultStr = new StringBuilder();
    //    int[] numArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    //    String[] strArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    //
    //        for (int i = 0; i < numArray.length; i++) {
    //            int count = num / numArray[i];
    //            if (count != 0) {
    //                for (int j = 0; j < count; j++) {
    //                    resultStr.append(strArray[i]);
    //                }
    //                num -= count * numArray[i];
    //                if (num == 0) {
    //                    break;
    //                }
    //            }
    //        }
    //    return resultStr.toString();
    //}
}
