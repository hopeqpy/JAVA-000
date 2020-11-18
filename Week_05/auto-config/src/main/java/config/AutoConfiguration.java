package config;

import model.Properties;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Configuration
@ConditionalOnClass(Student.class)
@ConditionalOnProperty(prefix = "autoconfig", name = "enabled", havingValue = "true", matchIfMissing = true)
@ConfigurationProperties(prefix = "autoconfig")
@EnableConfigurationProperties(Properties.class)
public class AutoConfiguration {

    @Autowired
    Properties studentProperties;

    @Bean
    public Student student() {
        Student student = new Student(studentProperties.getId(),studentProperties.getName());
        return student;
    }
}
