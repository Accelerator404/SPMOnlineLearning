package org.zeronight.spm;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class App 
{
	@Bean(name = "strutsFilter")
    public Filter strutsFilter() {
        return new org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter();
    }
	@Bean
    public FilterRegistrationBean strutsFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(strutsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("strutsFilter");
        return registration;
    }
	/**
     * 注入Hibernate的sessionFactory，以便Dao类中以Autowired方式使用
     * @return 
     */
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}

	/**
	 * 主函数，Spring Boot从这里运行
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
