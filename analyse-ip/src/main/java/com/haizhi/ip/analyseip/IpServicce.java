package com.haizhi.ip.analyseip;

import com.haizhi.ip.analyseip.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class IpServicce {

    //http://ip.taobao.com/outGetIpInfo?ip=222.79.150.11&accessKey=alibaba-inc
    private static final String IP_URL = "http://ip.taobao.com/outGetIpInfo?ip=%s&accessKey=alibaba-inc";
    private static final String IP_TEMPLATE = "%s.%s.%s.%s";
    private static final int BATCH_SIZE = 100;

    @Autowired
    private RestTemplate restTemplate;

    public void findOne() {
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(getIP(222, 79, 150, 11), Map.class);
        Map<String, Object> data = (Map<String, Object>)responseEntity.getBody();

        writeFile(data);
    }


    /**
     *{
     *     "data":{
     *         "ip":"222.79.150.11",
     *         "isp":"电信",
     *         "country":"中国",
     *         "isp_id":"100017",
     *         "city":"泉州",
     *         "city_id":"350500"
     *         "region":"福建",
     *         "region_id":"350000",
     *         "country_id":"CN",
     *     },
     *     "msg":"query success",
     *     "code":0
     * }
     */
    public void findIp() {
        //return String.format(IP_URL, String.format(IP_TEMPLATE, 222, 79, 150, 11));
        long count  = 0;
        long success  = 0;
        List<Map<String, String>> lines = new ArrayList<>(10);
        for (int first =1; first<= 255; first ++) {
            if (first == 10) {
                continue;
            }
            for (int two =0; two <= 255; two ++) {
                if ((first == 192 && two == 168) || (first == 172 && two >= 16 && two <= 31)) {
                    continue;
                }
                for(int i=0;i<= 255;i++) {
                    for(int j=0;j<= 255;j++) {
                        try {
                            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(getIP(222, 79, i, j), Map.class);
                            Map<String, Object> data = (Map<String, Object>)responseEntity.getBody();
                            log.info("data is :{}", data);
                            lines.add((Map<String, String>)data.get("data"));
                            if (lines.size() == BATCH_SIZE) {
                                writeLines(lines);
                                lines.clear();
                                Thread.sleep(1L);
                            }
                            success++;
                        } catch (RestClientException e) {
                            log.error("call ip analysis error :{}", e.getMessage());
                            count++;
                        } catch (InterruptedException e) {
                            log.error("sleep error :{}", e.getMessage());
                        }
                    }
                }
            }
        }

        log.info("call error times is :{}, success time is :{}", count, success);




    }

    private String getIP(int first, int second, int three, int four) {
//        return String.format(IP_URL, "222.79.150.11");
        return String.format(IP_URL, String.format(IP_TEMPLATE, "222", "79", three, four));
    }

    private void writeFile(Map<String, Object> data) {
        Map<String, String> result = (Map<String, String>) data.get("data");
        log.info("result is :{}", result);
        writeLines(Arrays.asList(result));
    }

    private void writeLines(List<Map<String, String>> data) {
        log.info("result lines  is :{}", data.size());
        FileUtil.addLine(FileUtil.FILE_PATH+FileUtil.FILE_NAME, data);
    }


}
