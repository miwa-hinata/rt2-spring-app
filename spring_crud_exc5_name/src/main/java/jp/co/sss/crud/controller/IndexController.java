package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.LoginResultBean;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.service.LoginService;

@Controller
public class IndexController {

	@Autowired
	LoginService loginService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute LoginForm loginForm) {
		return "index";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginForm loginForm, Model model, HttpSession sesson) {
        //Serviceクラスのexecuteメソッドを使って入力された情報でログインできるか判定して、判定結果を受け取る
		LoginResultBean loginResultBean = loginService.execute(loginForm);

		if (loginResultBean.isLogin()) {
			//ログインできるという判定、ログインしたユーザ情報をスコープに保存
			sesson.setAttribute("loginUser", loginResultBean.getLoginUser());
			return "redirect:/list";
		} else {
			model.addAttribute("errMessage", loginResultBean.getErrorMsg());
			return "index";
		}

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}

}
