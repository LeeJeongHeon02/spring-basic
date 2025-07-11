package hello.core.member;

/*
*   회원을 저장하고 찾는 기능을 구현하게 해주는 인터페이스이다.
* */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
