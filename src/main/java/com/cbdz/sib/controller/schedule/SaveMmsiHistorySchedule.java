package com.cbdz.sib.controller.schedule;

import com.cbdz.sib.service.SaveMmsiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 基于注解的定时器
 */
@Component
public class SaveMmsiHistorySchedule {
	private static final Logger logger = LoggerFactory.getLogger(SaveMmsiHistorySchedule.class);
	@Autowired
	private SaveMmsiService g_service;
	/**
	 * 每天夜里1点备份船站信息
	 */
	@Scheduled(cron = "0 0 1 * * ?")
	public void saveMmsi() {
		logger.info("SaveMmsiHistorySchedule start");
		g_service.saveData();
		logger.info("SaveMmsiHistorySchedule end");
	}
}