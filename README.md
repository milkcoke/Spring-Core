# Spring Core
스프링 핵심 원리를 파헤쳐보자!


## Spring Container 등록

```java
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

```

#### Configurations
아래 옵션이 지정되지 않은 경우 \
`@ComponentScan` 을 붙인 해당 패키지를 시작으로 예하 모든 패키지를 스캔한다.

> 위 메커니즘에 따라 **설정 정보 클래스 위치를 프로젝트 최상단에 두는 것이 관례가 되었다.**

- `basePackages` \
탐색할 패키지의 시작 위치 지정, 본 패키지를 포함한 모든 하위 패키지 탐색 \
여러 시작 위치를 지정할 수도 있음.
- `basePackageClasses` \
지정한 클래스의 패키지를 탐색 시작 위치로 지정

