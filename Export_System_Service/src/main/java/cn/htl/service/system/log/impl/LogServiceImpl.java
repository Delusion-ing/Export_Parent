package cn.htl.service.system.log.impl;

import cn.htl.dao.system.log.ILogDao;
import cn.htl.domain.system.log.Log;
import cn.htl.service.system.log.ILogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 16:02
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements ILogService {
    @Autowired
    ILogDao logDao;
    @Override
    public PageInfo<Log> findByPage(int curr, int pageSize, String companyId) {
        PageHelper.startPage(curr,pageSize);
        //调用全查
        List<Log> list = logDao.findAll(companyId);
        //包装成PageInfo
        PageInfo<Log> pi = new PageInfo<>(list);
        return pi;

    }

    @Override
    public void saveSysLog(Log log) {
        String uuid= UUID.randomUUID().toString();
        log.setId(uuid);
        logDao.save(log);

    }
}
