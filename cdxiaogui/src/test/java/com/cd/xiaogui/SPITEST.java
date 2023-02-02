package com.cd.xiaogui;


import com.sun.tools.javac.util.ServiceLoader;
import com.syw.demo.spi.SpiService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/11 3:06 下午
 */
@SpringBootTest
public class SPITEST {

    @Test
    public   void testSPI() {
        ServiceLoader<SpiService> decodeSetLoader = ServiceLoader.load(SpiService.class);

        for (SpiService decode : decodeSetLoader) {
            System.out.println(decode.toString());

        }

        System.out.println("end");

    }


}
