
package com.delta.cru.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.delta.cru.cnst.CmnCnst;
import com.delta.cru.dao.EmpDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@Service
public class EmpDtlsBoImpl implements EmpDtlsBoIfc {
	@Autowired
	private EmpDaoIfc daoIfc;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<EmpNmeVo> fndEmp(String empId) throws BsnObjExcp {
		List<EmpNmeVo> nmeVos = new ArrayList<>();
		try {
			nmeVos = daoIfc.fndEmp(empId);			
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}
		return nmeVos;
	}

	@Override
	public List<EmpPhVo> fndEmpPhns(String empId) throws BsnObjExcp {
		List<EmpPhVo> empPhs = new ArrayList<>();
		try {
			empPhs = daoIfc.fndEmpPhns(empId);
			for (EmpPhVo empPh : empPhs) {
				empPh.setEffDate(convertDateFormat(empPh.getEffDate()));
				empPh.setExpDate(convertDateFormat(empPh.getExpDate()));
				empPh.setCrtnGdttmDate(convertDateFormat(empPh.getCrtnGdttmDate()));
				empPh.setLstUpdtGdttmDate(convertDateFormat(empPh.getLstUpdtGdttmDate()));
			}
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}
		return empPhs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager", rollbackFor = BsnObjExcp.class)
	public int insPhn(EmpPhVo phInsVo) throws BsnObjExcp {
		try {
			Date sysDate = daoIfc.getSysDate();
			DateFormat dateFormat = new SimpleDateFormat(CmnCnst.DT_FRMT);
			if (phInsVo.getEffDate() == null) {
				phInsVo.setEffDate(dateFormat.format(sysDate));
			}
			if (phInsVo.getCrtnGdttmDate() == null) {
				phInsVo.setCrtnGdttmDate(dateFormat.format(sysDate));
			}
			if (phInsVo.getLstUpdtGdttmDate() == null) {
				phInsVo.setLstUpdtGdttmDate(dateFormat.format(sysDate));
			}
			return daoIfc.insPhn(phInsVo);
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager", rollbackFor = BsnObjExcp.class)
	public int updtPhn(EmpPhVo phUpdVo) throws BsnObjExcp {
		try {
			Date sysDate = daoIfc.getSysDate();
			if (StringUtils.isEmpty(phUpdVo.getEmplPhNum())) {
				phUpdVo.setEmplPhNum(null);
			}
			if (StringUtils.isEmpty(phUpdVo.getEmplNewPhNum())) {
				phUpdVo.setEmplNewPhNum(null);
			}
			if (StringUtils.isEmpty(phUpdVo.getEffDate())) {
				phUpdVo.setEffDate(null);
			}
			if (StringUtils.isEmpty(phUpdVo.getNewEffDate())) {
				phUpdVo.setNewEffDate(null);
			}
			if (StringUtils.isEmpty(phUpdVo.getPhTypCode())) {
				phUpdVo.setPhTypCode(null);
			}
			if (StringUtils.isEmpty(phUpdVo.getNewPhTypCode())) {
				phUpdVo.setNewPhTypCode(null);
			}
			DateFormat dateFormat = new SimpleDateFormat(CmnCnst.DT_FRMT);
			if (phUpdVo.getCrtnGdttmDate() == null) {
				phUpdVo.setCrtnGdttmDate(dateFormat.format(sysDate));
			}
			if (phUpdVo.getLstUpdtGdttmDate() == null) {
				phUpdVo.setLstUpdtGdttmDate(dateFormat.format(sysDate));
			}
			if (phUpdVo.getLstUpdtSqNum() == 0) {
				phUpdVo.setLstUpdtSqNum(daoIfc.getSeq());
			}
			return daoIfc.updtPhn(phUpdVo);
		} catch (DataAcesExcp acesExcp) {
			throw new BsnObjExcp(acesExcp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager", rollbackFor = BsnObjExcp.class)
	public int delPhn(EmpPhVo pkVo) throws BsnObjExcp {
		try {
			return daoIfc.delPhn(pkVo);
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}
	}

	public String convertDateFormat(String inptDte) throws BsnObjExcp {
		DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat writeFormat = new SimpleDateFormat(CmnCnst.DT_FRMT);
		Date date = null;
		try {
			if (null != inptDte) {
				date = readFormat.parse(inptDte);
			}
		} catch (ParseException prsExcp) {
			logger.error("Exception parsing date", prsExcp);
			throw new BsnObjExcp(prsExcp);
		}
		String formattedDate = "";
		if (date != null) {
			formattedDate = writeFormat.format(date);
		}
		return formattedDate;
	}

}
