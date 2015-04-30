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

/**
 * Created by Taras.Mykulyn on 28.04.2015.
 */
@Configuration
@ComponentScan("dao")
public class RootConfig {
    @Autowired
    @Bean
    UserRepository userRepository(SessionFactory sessionFactory) {
        UserRepository userRepository = new UserRepositoryImpl(sessionFactory);
        return userRepository;
    }
}
