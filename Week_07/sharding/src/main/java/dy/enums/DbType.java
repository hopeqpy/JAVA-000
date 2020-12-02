package dy.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Data
@AllArgsConstructor
public  enum DbType {
    MASTER("master"),
    SLAVE1("slave1"),
    SLAVE2("slave2");
    private String name;

    DbType(String name) {
        this.name = name;
    }


}
