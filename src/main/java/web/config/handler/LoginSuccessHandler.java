package web.config.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.service.MyUserDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public LoginSuccessHandler(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String name = httpServletRequest.getParameter("email");
        Long id = myUserDetailsService.getItemByEmail(name).getId();
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin/");
        } else {
            httpServletResponse.sendRedirect("/user/" + id);
        }
    }
}