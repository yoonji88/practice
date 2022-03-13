package com.kmong.demo.controller;

import java.util.List;
import java.util.Optional;

import com.kmong.demo.models.Member;
import com.kmong.demo.models.Product;
import com.kmong.demo.service.MemberService;
import com.kmong.demo.service.OrderService;
import com.kmong.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController  {
	@Autowired
	MemberService memberService;

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String home() { 
       System.out.println("controller start"); 
        return "index"; 
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "views/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(Member member) {
		
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		member.setPassword(scpwd.encode(member.getPassword()));
		memberService.save(member);
		return "views/login";
	}
		

    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "views/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(Member member) {
		System.out.println(member.getId()); 

		String pwd = member.getPassword();
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
		Optional<Member> mem = memberService.findById(member.getId());
		if(scpwd.matches(pwd, mem.get().getPassword())){//비번 암호화 해야됨		
			System.out.println("true  "); 
			return "views/mypage";
    	}
		return "error";

	}
	/*	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProductList() {
		
      // data
      List<Product> productList = productService.getProductList(id);
      model.addAttribute("productList", productList);

      // view
      model.addAttribute("template", "fragments/content/product/list");
      return "views/product";
	}
*/
}
