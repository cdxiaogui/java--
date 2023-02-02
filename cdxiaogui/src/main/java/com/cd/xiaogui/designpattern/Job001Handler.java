package com.cd.xiaogui.designpattern;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 10:33 上午
 */
public class Job001Handler extends JobHandle<String, Integer>{
    @Override
    public String handle(Integer flag) {
        if (flag == 1){
            return "执行Job001Handler完成";
        }else {
            if(getNext() == null){
                return "无人处理";
            }else {
                return (String) this.getNext().handle(flag);
            }
        }
    }
}
