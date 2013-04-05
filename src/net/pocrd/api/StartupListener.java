package net.pocrd.api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import net.pocrd.core.BaseServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 启动监听器
 */
@WebListener
public class StartupListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(StartupListener.class.getName());

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            BaseServlet.registerAll("net.pocrd.function");
        } catch (Exception e) {
            logger.fatal("application init failed. ====================================================================================", e);
        }
    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }
}
