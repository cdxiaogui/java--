package com.cd.xiaogui;

import com.alibaba.fastjson.JSON;
import com.cd.xiaogui.tool.ProcessCaller;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Slf4j
public class Test000 {

    @Test
    public void test0(){
        log.info("res:{}",this.testProcess(1));

    }

    public  Object testProcess(Integer first){

        return ProcessCaller.of(first,log)
                .map(this::testProcess001)
                .map(this::testProcess002)
                .accept(this::testProcess003)
//                .map(this::testProcess004)
                .get();
    }



    public String  testProcess001(Integer first){
        switch (first){
            case 1:
                return "第一部";
            case 2:
                return "第二部";
            default:
                return "默认的";

        }
    }
    public Boolean testProcess002(String sec){
        switch (sec){
            case "第一部":
            case "第二部":
                return true;
            default:
                return false;

        }
    }
    public void testProcess003( Boolean flag){
            testProcess001(flag? 1:2 );
    }

    public Integer testProcess004(Integer in){
        return in;
    }



    @Test
    public void testTime(){
        Long transformTimeMillis00 = 1657791016242L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(transformTimeMillis00 - 1000*60*60);  // 时间戳转Calendar
        System.out.println("2、时间戳转Calendar为：" + calendar);
        System.out.println("2、Calendar转时间戳为：" + calendar.getTimeInMillis());
        calendar.getTime();
    }

    @Test
    public void testMap(){
        Map<String ,String> map = new HashMap<>();
        AA a = new AA();
        a.setName("三九");
        a.setAge(19);
        map.put("aa", JSON.toJSONString(a));
        String dtoStr = JSON.toJSONString(map);
        log.info(dtoStr);
        Map<String ,String> res = JSON.parseObject(dtoStr, Map.class);
        log.info(JSON.toJSONString(res));
        AA a2 = JSON.parseObject(res.get("aa"), AA.class);
        a2.setName("1");
        log.info("res:" + a.equals(a2));
        String mapStr = "{\"44\":\"1\",\"12\":\"8\",\"34\":\"3\",\"24\":\"1\",\"26\":\"2\",\"37\":\"3\",\"39\":\"1\",\"29\":\"1\",\"190\":\"2\",\"191\":\"1\",\"281\":\"2\",\"186\":\"2\",\"275\":\"2\",\"342\":\"1\",\"239\":\"2\",\"9\":\"2\",\"328\":\"3\",\"62\":\"1\",\"51\":\"6\",\"691\":\"1\"}";
        Map<String ,String> map1 = JSON.parseObject(mapStr, Map.class);
        log.info("691:{}", map1.get("691"));
    }

}
@Data
class AA{
    String name;
    Integer age;
}

