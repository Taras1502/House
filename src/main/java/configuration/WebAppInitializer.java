package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Taras.Mykulyn on 28.04.2015.
 */
public class WebAppInitializer
            extends AbstractAnnotationConfigDispatcherServletInitializer {
        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }
        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class<?>[] { RootConfig.class, HibernateConfiguration.class, SecurityConfiguration.class};
        }
        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] { WebConfig.class };
        }
    }
