package com.cd.xiaogui.designpattern;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 10:33 上午
 */
public class Job002Handler extends JobHandle<String, Integer>{
    @Override
    public String handle(Integer flag) {
        if (flag == 2){
            return "执行Job002Handler完成";
        }else {
            if(getNext() == null){
                return "无人处理";
            }else {
                return (String) this.getNext().handle(flag);
            }
        }
    }
}
