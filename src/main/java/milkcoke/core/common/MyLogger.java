package milkcoke.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// This bean created uniquely when HTTP request occurs
// and destroyed the HTTP request finishing.
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void logging(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestUrl + "] " + message);
    }

    @PostConstruct
    public void init() {
        // 유일성 보장.
        // 로또 1등확률보다 낮음.
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "]" + "request scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "]" + " request bean destroyed: " + this);
    }
}
