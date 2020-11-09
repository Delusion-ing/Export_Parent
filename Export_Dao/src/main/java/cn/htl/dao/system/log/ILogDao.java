package cn.htl.dao.system.log;

import cn.htl.domain.system.log.Log;

import java.util.List;

/**
 * @ClassName ILogDao
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 16:05
 * @Version 1.0
 */
public interface ILogDao {
    void save(Log log);

    List<Log> findAll(String companyId);
}
