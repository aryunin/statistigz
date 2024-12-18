package com.statistigz.rcm.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

// TODO если можно, вынести в Common
@Component
@Log4j2
public final class CustomLogger {
    public void debug(Object object, String message) {
        log.debug(object.getClass().getSimpleName() + " " + object.hashCode() + " " + message);
    }
}
