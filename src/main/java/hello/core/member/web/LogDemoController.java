package hello.core.member.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myloggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody //문자 그대로 반환할때 사용
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        MyLogger myLogger = myloggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);
        myLogger.log("controller test end");
        logDemoService.logic("testId");
        return "OK";

    }

}
