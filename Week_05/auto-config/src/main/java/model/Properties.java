package model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Component
@ConfigurationProperties(prefix = "autoconfig.student")
@Data
public class Properties {

    private String id;

    private String name;

}
