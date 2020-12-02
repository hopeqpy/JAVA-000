package dy.mapper;

import com.dy.pojo.DUser;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public interface DUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DUser dUser);

    int insertSelective(DUser dUser);

    DUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DUser dUser);

    int updateByPrimaryKey(DUser dUser);
}
