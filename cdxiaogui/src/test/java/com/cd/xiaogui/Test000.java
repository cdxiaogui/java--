package com.cd.xiaogui;

import com.alibaba.fastjson.JSON;
import com.cd.xiaogui.tool.ProcessCaller;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
}

