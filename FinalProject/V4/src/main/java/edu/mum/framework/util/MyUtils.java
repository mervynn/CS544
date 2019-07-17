package edu.mum.framework.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    public static String toLowerFirstWord(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

    public static List<String> scanClasses(String packageName) {
        List<String> classNames = new ArrayList<>();
        String prefix = "".equals(packageName) ? "" : packageName + ".";
        // replace all . with /
        URL url = MyUtils.class.getClassLoader().getResource("/" + packageName
                .replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                // recursively read package
                List<String> subDirClasses = scanClasses(prefix + file.getName());
                classNames.addAll(subDirClasses);
            } else {
                String className = prefix + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
        return classNames;
    }

}
