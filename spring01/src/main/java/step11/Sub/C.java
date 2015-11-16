package step11.Sub;

import org.apache.log4j.Logger;

public class C {
	static Logger logger = Logger.getLogger(C.class);
	public void m() {
		logger.debug("C()...");
		logger.fatal("fatal 레벨 로그...");
		logger.error("error 레벨 로그...");
		logger.warn("warn 레벨 로그...");
		logger.info("info 레벨 로그...");
		logger.debug("debug 레벨 로그...");
		logger.trace("tarce 레벨 로그...");
	}
}
