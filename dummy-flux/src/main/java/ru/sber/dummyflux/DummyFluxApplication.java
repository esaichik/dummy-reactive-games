package ru.sber.dummyflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
@RequestMapping("/dummy/")
public class DummyFluxApplication {
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public static void main(String[] args) {
        SpringApplication.run(DummyFluxApplication.class, args);
    }

    private String generateString(int len) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        StringBuilder sb = new StringBuilder(len);
        SecureRandom sr = new SecureRandom();
        sb.append(CHAR_UPPER.charAt(sr.nextInt(CHAR_UPPER.length())));
        for (int i = 1; i < len; i++) {
            sb.append(CHAR_LOWER.charAt(sr.nextInt(CHAR_LOWER.length())));
        }
        return sb.toString();
    }

    private Duration generateDuration(int lower, int upper) {
        return Duration.ofMillis(new SecureRandom().nextInt(lower, upper));
    }

    @GetMapping(value = "/infiniteFlux")
    @CrossOriginForReactDevServer
    public Flux<MyData> generateInfiniteFlux() {
        return Flux.<MyData>generate(sink -> sink.next(new MyData(idGenerator.getAndIncrement(), generateString(10), generateString(5))))
                .delayElements(generateDuration(500, 2500));
    }

}

record MyData(int id, String firstName, String lastName) {
}
