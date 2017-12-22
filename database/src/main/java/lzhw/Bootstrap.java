package lzhw;

import lzhw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2017/1/19.
 */
@SpringBootApplication
@ImportResource("classpath:spring-core.xml")
@ServletComponentScan
public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Bootstrap.class,args);

    }
}
