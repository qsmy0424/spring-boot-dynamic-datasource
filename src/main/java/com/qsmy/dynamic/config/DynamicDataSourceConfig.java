package com.qsmy.dynamic.config;
import	java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author qsmy
 * @date 2019/9/28
 */
@Configuration
@MapperScan(basePackages = "com.qsmy.dynamic.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DynamicDataSourceConfig {

    @Bean(name = "PrimaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource getDataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SecondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource getDataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dataSource(@Qualifier("PrimaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("SecondaryDataSource") DataSource secondaryDataSource) {
        // targetDataSource集合是数据库与名字之间的映射
        Map<Object, Object> targetDataSource = new HashMap<>(2);
        targetDataSource.put(DataSourceType.DataBaseType.PRIMARY, primaryDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.SECONDARY, secondaryDataSource);
        DynamicDataSource datasource = new DynamicDataSource();
        datasource.setTargetDataSources(targetDataSource);
        datasource.setDefaultTargetDataSource(primaryDataSource);
        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*/*.xml"));
        return bean.getObject();
    }
}
