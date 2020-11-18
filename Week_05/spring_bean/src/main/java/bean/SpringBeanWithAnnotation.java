package bean;

import lombok.extern.slf4j.Slf4j;
import model.Learn;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class SpringBeanWithAnnotation {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register( SpringBeanWithAnnotation.class );

        applicationContext.refresh();

        Learn learn = applicationContext.getBean( "learnAnnotation", Learn.class );

        System.out.println( "des:" + learn.getDes() + ", name:" + learn.getName() );

        applicationContext.close();
    }

    // 1、通过bean方式
    @Bean(name = "learnAnnotation")
    public Learn getUser() {
        Learn learn = new Learn();
        learn.setDes( "描述" );
        learn.setName( "qpy" );
        return learn;
    }
}
