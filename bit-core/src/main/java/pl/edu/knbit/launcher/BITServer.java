package pl.edu.knbit.launcher;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.BlockingChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author mciolek
 */
public class BITServer extends Server implements InitializingBean, ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(BITServer.class);
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setParent(applicationContext);
        webApplicationContext.setConfigLocation("classpath:webApplicationContext.xml");
        webApplicationContext.setClassLoader(getClass().getClassLoader());

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setClassLoader(getClass().getClassLoader());
        contextHandler.setContextPath("/");

        contextHandler.addServlet(new ServletHolder(dispatcherServlet), "/api/*");

        setHandler(contextHandler);


        BlockingChannelConnector connector = new BlockingChannelConnector();
        connector.setPort(8080);
        addConnector(connector);

        try {
            this.start();
        } catch (Exception e) {
            LOGGER.error("Unexpected server error.", e);
            throw e;
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
