package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // 모든 스프링은 ApplicationContext으로 시작함. 이게 스프링 컨테이너라고 보면 됨
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 파라미터로 넘어간 AppConfig에 있는 환경 설정 정보를 가지고 스프링이 @Bean붙은걸
        // 컨테이너에 집어넣어서 관리해줌.

        // AppConfig에 있는 memberService라는 이름의 메서드가 Bean 객체로 등록된 상태고, 그걸 가져옴.
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member1 = new Member("A", 1L, Grade.VIP);

        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member1 " + member1.getName());
        System.out.println("findMember: " + findMember.getName());
    }
}
