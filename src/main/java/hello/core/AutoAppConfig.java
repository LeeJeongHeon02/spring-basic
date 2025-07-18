package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
//        Default값은 @ComponentScan이 붙은 설정 정보 클래스의 패키지 + 하위 패키지를 모두 탐색한다.
//        권장하는 방법은 설정 정보 클래스의 위치를 프로젝트의 최상단에 두는 것 이다.
        basePackages = "hello.core.member",

//         기존 AppConfig에서 만들어둔 설정 정보를 컴포넌트 스캔 대상에서 제외한다.
//         보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만
//         기존 예제 코드를 남겨두기 위해서 이 방법을 선택한것이다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
