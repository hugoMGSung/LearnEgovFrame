package egovframework.lab.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.lab.model.LoginCommand;
import egovframework.lab.model.LoginType;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	private String formView = "login/loginForm";
	private String successView = "login/loginSuccess";
	
	public String getFormView() {
		return formView;
	}
	public void setFormView(String formView) {
		this.formView = formView;
	}
	public String getSuccessView() {
		return successView;
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	
	@RequestMapping(value = "/loginProcess1.do", method = RequestMethod.GET)
	public String loginFormSetUp() {
		return getFormView();
	}

	@RequestMapping(value = "/loginProcess1.do", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("login") LoginCommand loginCommand) {
		return getSuccessView();
	}
	
	@ModelAttribute("loginTypes")
	protected List<LoginType> referenceData() throws Exception {
		List<LoginType> loginTypes = new ArrayList<LoginType>();
		loginTypes.add(new LoginType("A", "개인회원"));
		loginTypes.add(new LoginType("B", "기업회원"));
		loginTypes.add(new LoginType("C", "관리자"));
		return loginTypes;
	}
	
	@ModelAttribute("login")
	protected Object referenceData4login() throws Exception {
		return new LoginCommand();
	}
	
	@RequestMapping(value = "/memberInfo.do")
	public ModelAndView memberInfo(HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("login/memberInfo");
		
		if(httpSession.getAttribute("login")!= null)
		mav.addObject("login", httpSession.getAttribute("login"));
		
		return mav;
	}
	
	@RequestMapping(value = "/loginOut.do", method = RequestMethod.GET)
	public String logOut(SessionStatus sessionStatus) {
		if (!sessionStatus.isComplete())
			sessionStatus.setComplete();
		return "redirect:/loginProcess1.do";
	}
}
