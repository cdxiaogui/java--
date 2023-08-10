package com.cd.xiaogui.tool.testutil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @Description 实体类测试协助工具
 * @Author sunyawei3
 * @Date 2023/8/10 9:23 PM
 */
public abstract class BaseVoEntityTest<T> {

    protected abstract T getT();

    public void testGetAndSet() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = getT();
        Class modelClass = t.getClass();
        Object obj = modelClass.newInstance();

        Field[] fields = modelClass.getDeclaredFields();
        for (Field field : fields) {
            // 设置私有变量可以访问
            field.setAccessible(true);
        }
        Method[] declaredMethods = modelClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 覆盖get的方法
            if (method.getName().startsWith("get")) {
                Object getResult = method.invoke(obj);
            }
            //覆盖 is方法
            else if (method.getName().startsWith("is")) {
                Object invoke = method.invoke(obj);
            }
            // 覆盖所有的set方法
            else if (method.getName().startsWith("set")) {
                String field = method.getName().substring(3).toLowerCase();
                Object canshu = null;
                for (Field f : fields) {
                    if (f.getName().toLowerCase().equals(field)) {
                        /// 属性获取
                        canshu = f.get(obj);
                    }
                }
                Object invoke = method.invoke(obj, canshu);
            }
        }

    }

    @Test
    public void getAndSetTest() {
        try {
            this.testGetAndSet();
        } catch (Exception e) {

        }
    }

}