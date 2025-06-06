package fr.but3.gestion_alimentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Demarrage implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(Demarrage.class);
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Hello World !");

    }
}
