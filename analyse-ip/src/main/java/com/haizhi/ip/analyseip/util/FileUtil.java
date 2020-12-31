package com.haizhi.ip.analyseip.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;


/**
 *{
 *     "data":{
 *         "ip":"222.79.150.11",
 *         "isp":"电信",
 *         "isp_id":"100017",
 *         "country":"中国",
 *         "country_id":"CN",
 *         "region":"福建",
 *         "region_id":"350000",
 *         "city":"泉州",
 *         "city_id":"350500"
 *     },
 *     "msg":"query success",
 *     "code":0
 * }
 */
@Slf4j
public class FileUtil {

    public static String FILE_NAME = "ip.csv";
    public static String FILE_PATH = "./";
    public static String LINE_PATTERN = "%s,%s,%s,%s,%s,%s,%s,%s,%s";

    public static void addLine(String file, List<Map<String, String>> lines ) {

        BufferedWriter out = null;
        long time = System.currentTimeMillis();
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            for (int i=0;i< lines.size(); i++) {
                String line = String.format(LINE_PATTERN,
                        lines.get(i).get("ip"), lines.get(i).get("isp"),lines.get(i).get("isp_id"),
                        lines.get(i).get("country"),lines.get(i).get("country_id"),lines.get(i).get("region"),lines.get(i).get("region_id"),lines.get(i).get("city"),lines.get(i).get("city_id")
                );
                out.write(line+"\r\n");
            }
            log.info("write success :{}, time use is :{}", lines.size(), System.currentTimeMillis() - time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
