package org.xy.app;

import javax.sql.DataSource;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages="org.xy.dao")
public class DataSourceConfig {
	
	
	
	@Bean
	@ConfigurationProperties(prefix="dataSource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}
	
	@Bean
	@ConfigurationProperties(prefix="mapper")
	public SqlSessionFactory sqlSessionFactory(@Value("${mapper.location}") String location,
			@Value("${mapper.typePackage}") String typePackage) throws Exception {
		VFS.addImplClass(SpringBootVFS.class);
		SqlSessionFactoryBean ssfbean = new SqlSessionFactoryBean();
		ssfbean.setDataSource(dataSource());
		ssfbean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(location));
		ssfbean.setTypeAliasesPackage(typePackage);
		return ssfbean.getObject();
	}
	
}
