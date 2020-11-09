package cn.htl.service.system.log;

import cn.htl.domain.system.log.Log;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName ILogService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 16:00
 * @Version 1.0
 */
public interface ILogService {
    PageInfo<Log> findByPage(int curr, int pageSize, String companyId);

    void saveSysLog(Log log);
}
