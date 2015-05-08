package configuration;

import dao.UserRepository;
import dao.UserRepositoryImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import service.UserDetailsServiceImpl;

/**
 * Created by Taras.Mykulyn on 28.04.2015.
 */
@Configuration
@ComponentScan("java.*")
public class RootConfig {
    @Autowired
    @Bean
    UserRepository userRepository(SessionFactory sessionFactory) {
        UserRepository userRepository = new UserRepositoryImpl();

        return userRepository;
    }

    @Autowired
    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }

}
