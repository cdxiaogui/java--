//package com.cd.xiaogui.lomboktest;
//
//import com.sun.tools.javac.code.Flags;
//import com.sun.tools.javac.code.TypeTag;
//import com.sun.tools.javac.tree.JCTree;
//import com.sun.tools.javac.util.List;
//import com.sun.tools.javac.util.ListBuffer;
//import com.sun.tools.javac.util.Name;
//
//import javax.annotation.processing.SupportedAnnotationTypes;
//import javax.annotation.processing.SupportedSourceVersion;
//import javax.lang.model.SourceVersion;
//import java.lang.annotation.Annotation;
//
///**
// * todo
// *
// * @author sunyawei3
// * 创建时间 2022/10/26 6:02 下午
// */
//@SupportedAnnotationTypes("com.cd.xiaogui.lomboktest.SYWSetter") //注解处理器作用于哪个注解 也可以重写getSupportedAnnotationTypes
//@SupportedSourceVersion(SourceVersion.RELEASE_8) //可以处理什么版本 也可以重写getSupportedSourceVersion
//public class SYWSetterProcessor extends SYWAbstractProcessor{
//    @Override
//    public JCTree.JCMethodDecl makeMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {
//        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
//        //生成函数体 this.name = name;
//        statements.append(treeMaker.Exec(treeMaker.Assign(treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.getName()),treeMaker.Ident(jcVariableDecl.getName()))));
//        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());
//        //生成方法
//        return treeMaker.MethodDef(
//                treeMaker.Modifiers(Flags.PUBLIC), //访问标志
//                getNewMethodName(jcVariableDecl.getName()), //名字
//                treeMaker.TypeIdent(TypeTag.VOID), //返回类型
//                List.nil(), //泛型形参列表
//                List.of(getParameters(jcVariableDecl)), //参数列表
//                List.nil(), //异常列表
//                body, //方法体
//                null //默认方法（可能是interface中的那个default）
//        );
//    }
//
//    @Override
//    public Class<? extends Annotation> getAnnotation() {
//        return SYWSetter.class;
//    }
//
//    private Name getNewMethodName(Name name) {
//        String fieldName = name.toString();
//        return names.fromString("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, name.length()));
//    }
//
//    private JCTree.JCVariableDecl getParameters(JCTree.JCVariableDecl prototypeJCVariable) {
//        return treeMaker.VarDef(
//                treeMaker.Modifiers(Flags.PARAMETER), //访问标志
//                prototypeJCVariable.name, //名字
//                prototypeJCVariable.vartype, //类型
//                null //初始化语句
//        );
//    }
//}
