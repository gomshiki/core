package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 어디서부터 찾을지 시작위치 지정
        basePackageClasses = AutoAppConfig.class, // 시작할 클래스 지정
        // 지정하지 않으면 @ComponenetScan 이 붙은 설정 정보 클래스의 패키지가 시작위치로 default

        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 그중 뺼것 정의 : 다른 @Configuration 다 긁어와서 뺴도록 정의(기존 예제코드 유지를 위해)
) // @component를 찾아 스프링 빈으로 등록해줌
public class AutoAppConfig {

}
