//package com.cd.xiaogui;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.lang.Nullable;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Tests {
//    public static void main(String[] args) {
//        System.out.println(null instanceof Integer );
//
//        Integer integer = (Integer) null;
//        System.out.println(integer);
//        System.out.println(Collections.singletonList(123));
//        System.out.println(testBoolean(null));
//        String aa = "123";
//        ttt(aa);
//        System.out.println(aa);
//    }
//
//    private static boolean testBoolean(Boolean b){
//        return b;
//    }
//
//    public static boolean ttt(String a){
//        a = "1";
//        return false;
//    }
//
//    private List<Class> allowExc = new ArrayList<Class>(){{
//        add(AppExcepiton2.class);
////        add(AppExcepiton.class);
//    }};
//
//    @Test
//    public void testExcepiton(){
//        int arr[] = new int[3];
//
//        try {
//            try {
//                try {
//                    throw new AppExcepiton2("msg");
//                }catch (Exception e){
//                    throw new AppExcepiton("", e);
//                }
//
//            }catch (Exception e){
//                if(allowExc.stream().anyMatch(x -> getRootCause(e).getClass().equals(x))){
//                    System.out.println("========");
//                }else {
//                    System.out.println("没有匹配上都");
//                }
//
//                throw new Exception("message", e);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//
//            System.out.println(getRootCause(e) instanceof AppExcepiton2);
//        }
//
//
//    }
//    @Nullable
//    public static Throwable getRootCause(@Nullable Throwable original) {
//        if (original == null) {
//            return null;
//        } else {
//            Throwable rootCause = null;
//
//            for(Throwable cause = original.getCause(); cause != null && cause != rootCause; cause = cause.getCause()) {
//                rootCause = cause;
//            }
//
//            return rootCause;
//        }
//    }
//}
//class AppExcepiton extends Exception{
//    AppExcepiton(){}
//    AppExcepiton(String msg, Exception ee){
//        super("", ee);
//    }
//}
//
//class AppExcepiton2 extends Exception{
//    AppExcepiton2(){}
//    AppExcepiton2(String msg){
//        super(msg);
//    }
//    AppExcepiton2(String msg, Exception ee){
//        super("", ee);
//    }
//}
