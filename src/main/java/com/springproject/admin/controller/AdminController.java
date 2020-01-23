package com.springproject.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproject.admin.dto.MemberDto;
import com.springproject.admin.service.MemberService;
import lombok.AllArgsConstructor;

  
@Controller // This means that this class is a Controller
@ComponentScan("com.springproject.admin.service")
@AllArgsConstructor
public class AdminController{

    @Autowired
    private MemberService memberService;
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    /*
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    */
    /*
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewMember (@RequestParam String name
        , @RequestParam String email, @RequestParam String passwd) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
  
      Member n = new Member();
      n.setName(name);
      n.setEmail(email);
      n.setPasswd(passwd);
      memberRepository.save(n);
      return "Saved";
    }
  
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Member> getAllMembers() {
      // This returns a JSON or XML with the Members
      return memberRepository.findAll();
    }
    */
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
