package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Learn {


    private String des;

    private String name;


    public static Learn createLearn() {
        Learn learn = new Learn();
        learn.setDes( "描述" );
        learn.setName( "qpy" );
        return learn;
    }

}
