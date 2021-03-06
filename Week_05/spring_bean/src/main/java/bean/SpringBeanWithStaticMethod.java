package bean;

import model.Learn;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class SpringBeanWithStaticMethod {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext( "classpath:/bean-method.xml" );

        Learn learn = beanFactory.getBean( "learn", Learn.class );

        System.out.println( "des:" + learn.getDes() + ", name:" + learn.getName() );
    }
}
