package cn.ssm.mybatis;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源配置
 */
@Configuration
//扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionTemplateRef="masterSqlSessionTemplate")
public class MasterDataSourceConfig {

	// 精确到 master 目录，以便跟其他数据源隔离
	static final String PACKAGE = "cn.ssm.mapper.master";
	static final String MAPPER_LOCATION = "static/mapper/master/*.xml";
	
	@Value("${druid.master.url}")
	private String url;
	
	@Value("${druid.master.username}")
	private String user;
	
	@Value("${druid.master.password}")
	private String password;
	
	@Value("${druid.master.driverClassName}")
	private String driverClass;
	
	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
	 DruidDataSource dataSource = new DruidDataSource();
	 dataSource.setDriverClassName(driverClass);
	 dataSource.setUrl(url);
	 dataSource.setUsername(user);
	 dataSource.setPassword(password);
	 return dataSource;
	}
	
	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
	 return new DataSourceTransactionManager(masterDataSource());
	}
	
	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
	   throws Exception {
	 final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	 sessionFactory.setDataSource(masterDataSource);
	 sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
	     .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
	 return sessionFactory.getObject();
	}
	
	@Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
		
	/**
	 * jdbctemplate
	 * @author trojian
	 * @param dataSource
	 * @return
	 */
	 @Bean(name = "jdbctemplate")  
	 @Primary
	 public JdbcTemplate primaryJdbcTemplate(  
			 @Qualifier("masterDataSource") DataSource dataSource) {  
	     return new JdbcTemplate(dataSource);  
	 }  
	 
	 /**
	  * namedParameterJdbcTemplate
	  * @author trojian
	  * @param dataSource
	  * @return
	  */
	 @Bean(name = "namedParameterJdbcTemplate")  
	 @Primary
	 public NamedParameterJdbcTemplate NamedParameterJdbcTemplate(  
			 @Qualifier("masterDataSource") DataSource dataSource) {  
		 return new NamedParameterJdbcTemplate(dataSource);  
	 }  
}