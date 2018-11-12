package com.delta.cru.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.delta.cru.dao.mapper.EmpMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@Repository
public class EmpDaoImpl implements EmpDaoIfc {	
    @Autowired
    private EmpMapperIfc mapperIfc;

    @Override
    public List<EmpNmeVo> fndEmp(String empId) throws DataAcesExcp {
        List<EmpNmeVo> empls = null;
        try {
            empls = mapperIfc.fndEmp(empId);
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
        return empls;
    }

    @Override
    public List<EmpPhVo> fndEmpPhns(String empId) throws DataAcesExcp {
        List<EmpPhVo> empls = null;
        try {
            empls = mapperIfc.fndEmpPhns(empId);
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
        return empls;
    }

    @Override
    public int insPhn(EmpPhVo employee) throws DataAcesExcp {
        try {
            return mapperIfc.insPhn(employee);
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
    }

    @Override
    public int updtPhn(EmpPhVo employee) throws DataAcesExcp {
        Integer status = null;
        try {
            status = mapperIfc.updtPhn(employee);
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
        return status;
    }

    @Override
    public int delPhn(EmpPhVo employee) throws DataAcesExcp {
        try {
            return mapperIfc.delPhn(employee);
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
    }

    @Override
    public Date getSysDate() throws DataAcesExcp {
        Date sysDate = null;
        try {
            sysDate = mapperIfc.getSysDate();
        } catch (DataAccessException excp) {
            throw new DataAcesExcp(excp);
        }
        return sysDate;
    }

    @Override
    public long getSeq() throws DataAcesExcp {
        return mapperIfc.getSeq();
    }
}
