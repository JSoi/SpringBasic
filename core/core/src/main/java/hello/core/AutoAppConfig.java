package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Configuration.class}),
        basePackages= "hello.core",
        basePackageClasses = AutoAppConfig.class
)
//@Configuration 붙은 Appconfig도 긁어오기 때문에 충돌이 난다..! 그래서 excludeFilters
//예제 코드를 살리기 위해서 추가한 코드!
//ComponentScan 역시 Component 어노테이션 포함
public class AutoAppConfig {
    // 스프링 빈을 자동으로 긁어온다
    /*
    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    */

}
