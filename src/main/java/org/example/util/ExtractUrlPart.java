package org.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Author: Ron
 * @Create: 2024-05-24 下午3:48
 */
public class ExtractUrlPart {

    /**
     * 从一个URL中提取特定格式的子字符串
     * @param args
     */
    public static void main(String[] args) {
        // 示例URL，目标是提取其中的jpg图片地址
        String url = "https://p3.douyinpic.com/aweme/720x720/aweme-avatar/tos-cn-i-c9aec8xkvj_fa1ccd43d64c498796a6285b15b1a646.heic?from=2956013662&$$dyurl=https://logocdn.feigua.cn/BloggLogo/d629bf66a1f4cd03e616588b780e15d2.jpg-jpg";

        // 定义正则表达式模式，用于匹配URL中的jpg图片地址
        String patternString = "dyurl=(.*\\.jpg)";
        Pattern pattern = Pattern.compile(patternString); // 编译正则表达式
        Matcher matcher = pattern.matcher(url); // 创建匹配器

        if (matcher.find()) {
            // 如果找到匹配项，输出提取的图片地址
            System.out.println(matcher.group(1));  // 输出: https://logocdn.feigua.cn/BloggLogo/d629bf6a1f4cd03e61658b780e15d2.jpg
        } else {
            System.out.println("No match found");
        }
    }
}