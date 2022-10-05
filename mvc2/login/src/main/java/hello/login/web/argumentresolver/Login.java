package hello.login.web.argumentresolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 파라미터에 적용
@Retention(RetentionPolicy.RUNTIME) // 런타임 시점까지 정보 유지
public @interface Login {
}
