package model;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 * @create: 2020-11-18 21:51
 */
public class InstanceBean {


    public Learn createLearn() {
        Learn learn = new Learn();
        learn.setDes( "描述" );
        learn.setName( "qpy" );
        return learn;
    }
}
