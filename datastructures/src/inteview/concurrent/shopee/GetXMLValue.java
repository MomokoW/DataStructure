package inteview.concurrent.shopee;

/**
 * Created by momoko on 2021/8/2.
 * 提取XML的值
 * 详细描述
 * 给定一个简单XML字符串，可能包含XML的嵌套，输入一个路径，输出对应路径的值，如果不存在则返回空字符串
 *
 * 输入：
 * "<people><name>shopee</name></people>","people.name"
 * 输出：
 * "shopee"
 */
public class GetXMLValue {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param inxml string字符串 xml字符串
     * @param path string字符串 取值路径
     * @return string字符串
     */
    public static String getXMLValue(String inxml, String path) {
        // 首先把目标字符串构建成嵌套的形式
        StringBuilder sbStart = new StringBuilder();
        StringBuilder sbEnd = new StringBuilder();
        String[] paths = path.split("\\.");

        for (int i = 0; i < paths.length; i++) {
           sbStart.append("<");
           sbEnd.append("</");
           sbStart.append(paths[i]);
           sbEnd.append(paths[paths.length - 1 - i]);
           sbStart.append(">");
           sbEnd.append(">");
        }

        String start = sbStart.toString();
        String end = sbEnd.toString();
        // 判断是否包含目标字符
        if (!inxml.contains(start)) {
            return "";
        }
        String res = inxml.substring(start.length(), inxml.length() - end.length());
        return res;
    }

    public static void main(String[] args) {
        String xml = "<people><name>shopee</name></people>";
        String xmlValue = getXMLValue(xml, "people.age");
        System.out.println(xmlValue);

    }
}
