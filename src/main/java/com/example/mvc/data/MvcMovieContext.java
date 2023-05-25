package com.example.mvc.data;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableJpaRepositories(basePackages = {"com.example.mvc.data"})
public class MvcMovieContext {
/*    private final DataSource dataSource;

    public MvcMovieContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("MvcMovie.Models");
        return em;
    }

    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager(entityManagerFactory);
        return tm;
    }*/
}

