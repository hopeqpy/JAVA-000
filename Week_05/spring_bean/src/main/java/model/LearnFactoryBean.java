package model;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class LearnFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return Learn.builder().des( "ceshi" ).name( "qpy" ).build();
    }

    @Override
    public Class<?> getObjectType() {
        return Learn.class;
    }
}
