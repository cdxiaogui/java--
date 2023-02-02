package classes.com.cd.xiaogui.lomboktest;

import lombok.Data;

/**
 * 测试 spring.factories
 * 类似 spi
 *
 * @author sunyawei3
 * 创建时间 2022/11/10 4:36 下午
 */
@Data
public class A {
    String name;

    public A(String name) {
        this.name = name;
    }
}
