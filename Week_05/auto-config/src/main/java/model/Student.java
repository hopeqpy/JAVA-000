package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Data
@AllArgsConstructor
public class Student {

    private String id;

    private String name;
}
