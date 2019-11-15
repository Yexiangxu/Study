package com.mmfq.lazyxu.annotation;

import com.google.auto.service.AutoService;
import com.mmfq.lazyxu.annotation.utils.Log;
import com.mmfq.lazyxu.apt_annotation.ArouterUrl;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * Date: 2019/3/13 15:46
 * Author: Xuyexiang
 * Title:
 */
@AutoService(Processor.class)
//用来自动生成META-INF/services/javax.annotation.processing.Processor文件的（这是一个在其他注解处理器中引入的注解。AutoService注解处理器是Google开发的）
//@SupportedSourceVersion(SourceVersion.RELEASE_8)//java版本支持
//@SupportedAnnotationTypes({"com.mmfq.lazyxu.apt_annotation.ArouterUrl"})//标注注解处理器支持的注解类型
public class AnnotationProcessor extends AbstractProcessor {
    private Elements mElementUtils;
    private Types mTypeUtils;
    private Filer mFiler;
    private Log log;

    /**
     * 注解处理器可以支持的注解类型
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //因为兼容的原因建议用该方式，跟上面设置路径的一样
        Set<String> annotations = new LinkedHashSet<String>();
        annotations.add(ArouterUrl.class.getCanonicalName());
        return annotations;
//      return Collections.singleton(ArouterUrl.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 返回注解处理器可处理的注解操作
     */
    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }

    /**
     * 初始化处理器，在这里获取我们需要的工具类
     */
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        //Element代表程序的元素，例如包、类、方法。
        mElementUtils = env.getElementUtils();
        //处理TypeMirror的工具类，用于取类信息
        mTypeUtils = env.getTypeUtils();
        //Filer可以创建文件
        mFiler = env.getFiler();
        //获得apt的日志输出
        log = Log.newLog(env.getMessager());
    }

    /**
     * 这相当于每个处理器的主函数main()
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //MethodSpec:定义方法
        MethodSpec main = MethodSpec.methodBuilder("go")//定义方法名
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)//设置方法为 public static
                .returns(void.class)//设置方法返回类型
                .addParameter(String.class, "name")//设置方法参数
                .addParameter(HashMap.class, "extra")
                //Toast.makeText(MainActivity.this, "绑定成功了", Toast.LENGTH_SHORT).show()
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();
        TypeSpec routerTest = TypeSpec.classBuilder("RouterTest")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.lazyxu.arouterurl", routerTest).build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}