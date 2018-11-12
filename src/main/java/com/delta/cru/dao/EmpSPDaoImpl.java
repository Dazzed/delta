package com.delta.cru.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.delta.cru.cnst.CmnCnst;
import com.delta.cru.dao.mapper.EmpSPMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpPhVo;

@Repository
public class EmpSPDaoImpl implements EmpSPDaoIfc {
	@Autowired
	private EmpSPMapperIfc mapperIfc;

	@Override
	public int insPhnBySP(EmpPhVo empl) throws DataAcesExcp {
		int rtrncd = 0;
		try {
			mapperIfc.insPhnBySP(empl);
			if (Integer.parseInt(empl.getRtnCd()) < 0) {
				throw new DataAcesExcp("Exception in insertPhnBySP- Error Code:[" + empl.getRtnCd() + CmnCnst.ERR_MSG
						+ empl.getRtnMsg() + "]");
			} else if (Integer.parseInt(empl.getRtnCd()) == 0 && empl.getRtnMsg().equals(CmnCnst.INSRT_MSG)) {
				rtrncd = Integer.parseInt(empl.getRtnCd());
			}
			return rtrncd;
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int updtPhnBySP(EmpPhVo empl) throws DataAcesExcp {
		int rtrncd = 0;
		try {
			mapperIfc.updtPhnBySP(empl);
			if (Integer.parseInt(empl.getRtnCd()) < 0) {
				throw new DataAcesExcp("Exception in updatePhnBySP- Error Code:[" + empl.getRtnCd() + CmnCnst.ERR_MSG
						+ empl.getRtnMsg() + "]");
			} else if (Integer.parseInt(empl.getRtnCd()) == 0 && empl.getRtnMsg().equals(CmnCnst.UPDT_MSG)) {
				rtrncd = Integer.parseInt(empl.getRtnCd());
			}
			return rtrncd;
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int delPhnBySP(EmpPhVo empl) throws DataAcesExcp {
		int rtrncd = 0;
		try {
			mapperIfc.delPhnBySP(empl);
			if (Integer.parseInt(empl.getRtnCd()) < 0) {
				throw new DataAcesExcp("Exception in deletePhnBySP- Error Code:[" + empl.getRtnCd() + CmnCnst.ERR_MSG
						+ empl.getRtnMsg() + "]");
			} else if (Integer.parseInt(empl.getRtnCd()) == 0 && empl.getRtnMsg().equals(CmnCnst.DLTE_MSG)) {
				rtrncd = Integer.parseInt(empl.getRtnCd());
			}
			return rtrncd;
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
