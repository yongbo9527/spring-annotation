package org.example.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ron
 * @Create: 2023-05-24 17:56
 */
public class Yellow {
    public static void main(String[] args) {
        List<String> newsTitles = new ArrayList<>();
        newsTitles.add("Java程序员大会");
        newsTitles.add("Java开发者大会");
        newsTitles.add("Java开发指南");
        newsTitles.add("Python程序员大会");

        List<String> uniqueTitles = removeDuplicates(newsTitles, 0.5);
        System.out.println("去重后的标题：");
        for (String title : uniqueTitles) {
            System.out.println(title);
        }
    }

    public static List<String> removeDuplicates(List<String> titles, double similarityThreshold) {
        List<String> uniqueTitles = new ArrayList<>();
        uniqueTitles.add(titles.get(0));

        for (int i = 1; i < titles.size(); i++) {
            String currentTitle = titles.get(i);
            boolean isDuplicate = false;

            for (String uniqueTitle : uniqueTitles) {
                double similarity = calculateSimilarity(currentTitle, uniqueTitle);
                if (similarity >= similarityThreshold) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueTitles.add(currentTitle);
            }
        }

        return uniqueTitles;
    }

    public static double calculateSimilarity(String title1, String title2) {
        int maxLength = Math.max(title1.length(), title2.length());
        int distance = levenshteinDistance(title1, title2);
        return 1 - (double) distance / maxLength;
    }

    public static int levenshteinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost));
            }
        }

        return dp[m][n];
    }
}
