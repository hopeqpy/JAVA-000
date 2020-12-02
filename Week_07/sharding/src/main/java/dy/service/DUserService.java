package dy.service;

import com.dy.pojo.DUser;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public interface DUserService {


    void save();

    DUser selectByPrimaryKey(Long id);
}
