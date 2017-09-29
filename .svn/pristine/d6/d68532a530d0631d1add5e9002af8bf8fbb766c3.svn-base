package cn.ssm.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 从数据源配置
 */
//@Configuration
//扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = SlaveDataSourceConfig.PACKAGE,sqlSessionTemplateRef="slaveSqlSessionTemplate")
public class SlaveDataSourceConfig {
	
	// 精确到 slave 目录，以便跟其他数据源隔离
	static final String PACKAGE = "cn.ssm.mapper.slave";
	static final String MAPPER_LOCATION = "cn/ssm/mapper/slave/*.xml";
	
	@Value("${druid.slave.url}")
	private String url;
	
	@Value("${druid.slave.username}")
	private String user;
	
	@Value("${druid.slave.password}")
	private String password;
	
	@Value("${druid.slave.driverClassName}")
	private String driverClass;
	
	@Bean(name = "slaveDataSource")
	public DataSource slaveDataSource() {
	 DruidDataSource dataSource = new DruidDataSource();
	 dataSource.setDriverClassName(driverClass);
	 dataSource.setUrl(url);
	 dataSource.setUsername(user);
	 dataSource.setPassword(password);
	 return dataSource;
	}
	
	@Bean(name = "slaveTransactionManager")
	public DataSourceTransactionManager slaveTransactionManager() {
	 return new DataSourceTransactionManager(slaveDataSource());
	}
	
	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
	   throws Exception {
	 final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	 sessionFactory.setDataSource(slaveDataSource);
	 sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
	     .getResources(SlaveDataSourceConfig.MAPPER_LOCATION));
	 return sessionFactory.getObject();
	}
	
	@Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}