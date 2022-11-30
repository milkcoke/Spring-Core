package milkcoke.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 패키지를 찾을 시작 위치를 지정할 수 있음.
        basePackages = "milkcoke.core",
        // Configuration 붙은 클래스는 제외 (ex. AppConfig)하여 충돌 방지
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // DI 를 생성자 없이 어떻게 할 것인가? => AutoWired!

}
