package cn.bigears.poi.trace;

import cn.bigears.poi.ExcelFileUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 将特定目录下，名称类似 ai_trace.log_20240102.log
 * 的日志文件，导出成excel
 * @author shenyang
 * @date 2023-12-29
 */
public class AiTraceLog {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/bigears/Desktop/ai");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Optional.ofNullable(files).ifPresent(
                    item -> Arrays.stream(item).forEach(itemFile -> {
                        try {
                            export(itemFile);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    })
            );
        }
    }

    private static void export(File file) throws IOException {
        if (file.isDirectory()) {
            return;
        }
        if (!file.getName().startsWith("ai_trace")) {
            return;
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<AiTrace> aiTraceList = new ArrayList<>();
        String json;
        AiTrace aiTrace;
        while ((json = bufferedReader.readLine()) != null) {
            aiTrace = JSONObject.parseObject(json, AiTrace.class);
            aiTraceList.add(aiTrace);
        }
        bufferedReader.close();
        fileReader.close();

        String[] headers = new String[]{"用户登录名", "企业名称", "访问时间"};
        String[] fields = new String[]{"loginName", "companyName", "time"};
        String fileName = getExportFileName(file);
        ExcelFileUtil.exportFile(true, fileName, headers, fields, aiTraceList, null, "/Users/bigears/Desktop/ai/export/");
    }

    private static String getExportFileName(File file) {
        String name = file.getName();
        String date = name.replace("ai_trace.log", "").replace(".log", "");
        return "AI访问统计" + date + ".xls";
    }

}
