package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)//가짜 프록시 클래스를 만들어 집어놓음
public class MyLogger { //로그 출력을 위한 클래스
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("["+uuid+"]  [" + requestURL +"] "+message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] requestURL scope bean create : "+ this);

    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] requestURL scope bean close : "+ this);
    }
}
