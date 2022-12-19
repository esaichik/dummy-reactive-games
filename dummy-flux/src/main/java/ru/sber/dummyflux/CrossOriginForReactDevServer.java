package ru.sber.dummyflux;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@CrossOrigin("http://localhost:3000")
public @interface CrossOriginForReactDevServer {
}
