package cn.bigears.base.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FilesTest
 * @author shenyang
 * @date 2025-11-11
 */
public class FilesTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/bigears/Desktop/1111");
        // 遍历2级
        Files.walk(path, 2).forEach(item -> {
            System.out.println(item.getFileName());
        });
    }

}
