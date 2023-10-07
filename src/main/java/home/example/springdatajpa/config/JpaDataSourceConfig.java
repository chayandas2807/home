package home.example.springdatajpa.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JpaDataSourceConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("home.example.springdatajpa.entity");
		em.getJpaDialect();

		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setJpaPropertyMap(additionalProperties());

		return em;
	}

	private Map<String, ?> additionalProperties() {
		Map<String, Object> map = new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.format_sql", true);
		map.put("hbm2ddl.auto", "create-drop");
		
		return map;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.SQL_SERVER);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		return vendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	    return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
}
