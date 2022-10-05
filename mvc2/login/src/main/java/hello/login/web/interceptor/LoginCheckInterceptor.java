package hello.login.web.interceptor;

import hello.login.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String loginId = UUID.randomUUID().toString();
        HttpSession httpSession = request.getSession(false);
        log.info("PREHANDLE : [{}][{}]", loginId, requestURI);
        if (httpSession == null || httpSession.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            log.info("미인증 사용자 요청");
            response.sendRedirect("/login?redirectURI=" + requestURI);
            return false;
        }
        return true;
    }
}
