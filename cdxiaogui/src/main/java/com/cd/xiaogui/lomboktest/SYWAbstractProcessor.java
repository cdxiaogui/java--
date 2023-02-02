package com.cd.xiaogui.lomboktest;



import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.util.Set;


public abstract class SYWAbstractProcessor extends AbstractProcessor {
    //语法树
    protected JavacTrees trees;

    //构建语法树节点
    protected TreeMaker treeMaker;

    //创建标识符的对象
    protected Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //获取注解标识的类
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(getAnnotation());
        //拿到语法树
        set.stream().map(element -> trees.getTree(element)).forEach(jcTree -> jcTree.accept(new TreeTranslator() {
            //拿到类定义
            @Override
            public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                List<JCTree.JCVariableDecl> jcVariableDeclList = List.nil();
                //拿到所有成员变量
                for (JCTree tree : jcClassDecl.defs) {
                    if (tree.getKind().equals(Tree.Kind.VARIABLE)) {
                        JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl) tree;
                        jcVariableDeclList = jcVariableDeclList.append(jcVariableDecl);
                    }
                }

                jcVariableDeclList.forEach(jcVariableDecl -> {
                    jcClassDecl.defs = jcClassDecl.defs.prepend(makeMethodDecl(jcVariableDecl));
                });
                super.visitClassDef(jcClassDecl);
            }
        }));
        return true;
    }

    /**
     * 创建方法
     * @param jcVariableDecl
     * @return
     */
    public abstract JCTree.JCMethodDecl makeMethodDecl(JCTree.JCVariableDecl jcVariableDecl);

    /**
     * 获取何种注解
     * @return
     */
    public abstract Class<? extends Annotation> getAnnotation();
}
