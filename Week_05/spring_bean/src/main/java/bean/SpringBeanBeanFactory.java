package bean;

import model.Learn;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class SpringBeanBeanFactory {

    public static void main(String[] args) {
        // bean factory
        BeanFactory beanFactory = new ClassPathXmlApplicationContext( "classpath:/bean-bean-factory.xml" );

        Learn learn = beanFactory.getBean( "learn", Learn.class );

        System.out.println( "des:" + learn.getDes() + ", name:" + learn.getName() );

    }
}
