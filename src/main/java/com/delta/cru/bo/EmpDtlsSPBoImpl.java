package com.delta.cru.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.delta.cru.cnst.CmnCnst;
import com.delta.cru.dao.EmpSPDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpPhVo;

@Service
public class EmpDtlsSPBoImpl implements EmpDtlsSPBoIfc {
	@Autowired
	private EmpSPDaoIfc spDaoIfc;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insPhnBySP(EmpPhVo phInsVo) throws BsnObjExcp {
		try {
			Date sysDate = spDaoIfc.getSysDate();
			DateFormat df = new SimpleDateFormat(CmnCnst.DT_FRMT);
			if (phInsVo.getEffDate() == null) {
				phInsVo.setEffDate(df.format(sysDate));
			}
			if (phInsVo.getCrtnGdttmDate() == null) {
				phInsVo.setCrtnGdttmDate(df.format(sysDate));
			}
			if (phInsVo.getLstUpdtGdttmDate() == null) {
				phInsVo.setLstUpdtGdttmDate(df.format(sysDate));
			}
			return spDaoIfc.insPhnBySP(phInsVo);
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updtPhnBySP(EmpPhVo phUpdVo) throws BsnObjExcp {
		try {
			Date sysDate = spDaoIfc.getSysDate();
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
			DateFormat df = new SimpleDateFormat(CmnCnst.DT_FRMT);
			if (phUpdVo.getCrtnGdttmDate() == null) {
				phUpdVo.setCrtnGdttmDate(df.format(sysDate));
			}
			if (phUpdVo.getLstUpdtGdttmDate() == null) {
				phUpdVo.setLstUpdtGdttmDate(df.format(sysDate));
			}
			if (phUpdVo.getLstUpdtSqNum() == 0) {
				phUpdVo.setLstUpdtSqNum(spDaoIfc.getSeq());
			}
			return spDaoIfc.updtPhnBySP(phUpdVo);
		} catch (DataAcesExcp acesExcp) {
			throw new BsnObjExcp(acesExcp);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delPhnBySP(EmpPhVo pkVo) throws BsnObjExcp {
		try {
			return spDaoIfc.delPhnBySP(pkVo);
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}
	}

}
