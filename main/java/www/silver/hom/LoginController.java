package www.silver.hom;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.silver.vo.MemberVO;
import www.silver.service.IF_memberService;

@Controller
public class LoginController {
	
	@Inject
	IF_memberService memberservice;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logins(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest request,RedirectAttributes rttr, Model model) {
		MemberVO mvo=memberservice.viewDetail(id);
		
		if(mvo!=null) {
			if(password.equals(mvo.getPassword())) {
				HttpSession session =request.getSession();
				if(session.getAttribute("id")==null) {
					session.removeAttribute("id");
					
				}
				session.setAttribute("id", mvo.getUserid());
			
			}
		}
		
		return "redirect:/memberjoin";
	}
    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/memberjoin"; // 메인 페이지로 리다이렉트
    }
}