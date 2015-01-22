package pl.edu.knbit.launcher;

import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author mciolek
 */
public class BITLauncher {
    private ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        BITLauncher bitLauncher = new BITLauncher();
        bitLauncher.launch();
    }

    private void launch() {
        context = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }
}