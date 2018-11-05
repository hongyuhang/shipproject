package com.cbdz.sib.service;

import com.cbdz.sib.common.Constant;
import com.cbdz.sib.dao.MmsiCurrentMapper;
import com.cbdz.sib.dao.MmsiHistoryMapper;
import com.cbdz.sib.model.MmsiCurrentExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@Service
public class SaveMmsiService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MmsiCurrentMapper g_mapperCurrent;
    @Autowired
    private MmsiHistoryMapper g_mapperHistory;

    @Transactional
    public void saveData() {
        int p_saveTime = Constant.getExtensionConfigInt(Constant.Key.CFG_MMSI_SAVE_TIME);
        Calendar p_cal = Calendar.getInstance();
        p_cal.add(Calendar.HOUR, 0 - p_saveTime);

        // 过期数据移动至历史表
        g_mapperHistory.saveMmsiHistory(p_cal.getTime());

        // 删除过期数据
        MmsiCurrentExample p_mc = new MmsiCurrentExample();
        p_mc.createCriteria().andRTimeLessThanOrEqualTo(p_cal.getTime());
        int p_cnt = g_mapperCurrent.deleteByExample(p_mc);

        logger.info("SaveMmsiService.saveData() delete count = " + p_cnt);
    }
}
