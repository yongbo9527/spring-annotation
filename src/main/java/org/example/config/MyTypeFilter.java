package org.example.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * @Author: Ron
 * @Create: 2024-05-23 下午8:55
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * 根据给定的类元数据和工厂，决定当前扫描的类是否匹配特定条件。
     *
     * @param metadataReader 提供当前扫描类的注解元数据和类元数据。
     * @param metadataReaderFactory 可用于获取任何其他类的元数据的工厂。
     * @return boolean 如果当前类名称包含"er"，则返回true，表示匹配；否则返回false。
     * @throws IOException 如果读取元数据时发生IO异常。
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        // 获取并处理当前类的注解元数据、类元数据和资源信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        Resource resource = metadataReader.getResource();

        // 获取当前类的完整名称
        String className = classMetadata.getClassName();
        System.out.println("--->"+className);

        // 判断类名是否包含"er"，是则匹配，返回true
        if(className.contains("er")){
            return true;
        }

        // 不包含"er"，不匹配，返回false
        return false;
    }

}