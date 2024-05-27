package org.example.impl;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 自定义逻辑，放回需要导入的组件
 * @Author: Ron
 * @Create: 2023-05-24 17:45
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值：就是要导入到容器中的组件的全类名
     *
     * @param importingClassMetadata
     *  AnnotentionMetadata：当前标注@Import注解类的所有注解信息，也就是说不仅能获取到@Import注解里面的信息，还能获取到其他注解的信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org.example.bean.Blue", "org.example.bean.Yellow"};
    }
}
