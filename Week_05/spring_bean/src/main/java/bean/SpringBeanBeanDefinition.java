package bean;

import model.Learn;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class SpringBeanBeanDefinition {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        registryBeanDefinition( applicationContext, "learnDefinition" );
        applicationContext.refresh();
        Learn learn = applicationContext.getBean( "learnDefinition", Learn.class );
        System.out.println( "des:" + learn.getDes() + ", name:" + learn.getName() );
        applicationContext.close();
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition( Learn.class );
        beanDefinitionBuilder.addPropertyValue( "des", "hh" )
                .addPropertyValue( "name", "qpy" );
        registry.registerBeanDefinition( beanName, beanDefinitionBuilder.getBeanDefinition() );
        BeanDefinitionReaderUtils.registerWithGeneratedName( beanDefinitionBuilder.getBeanDefinition(), registry );

    }
}
