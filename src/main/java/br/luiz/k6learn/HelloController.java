package br.luiz.k6learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/{sleep}")
    public Callable<String> sleep(@PathVariable Long sleep) throws InterruptedException {
        return () -> {
            log.info("{} - Testando", Thread.currentThread());
            Thread.sleep(sleep);
            return "end";
        };
    }
}
