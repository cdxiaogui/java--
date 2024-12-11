package com.cd.xiaogui.demo;

import com.cd.xiaogui.demo.dto.PreStartBeanDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  测试bean
 *
 * @author sunyawei3
 * @date 2023/3/20 6:05 下午
 */
@Configuration
public class BeanTest {

//    @Value("${cd.name}")
    private String name;

    @Bean
    public PreStartBeanDTO preStartBeanDTO(){
        PreStartBeanDTO dto = new PreStartBeanDTO();
        dto.setName(name);
        dto.setAge(999999);
        dto.setMoney(999999L);
        return dto;
    }

}
