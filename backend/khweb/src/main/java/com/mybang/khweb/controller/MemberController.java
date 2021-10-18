package com.mybang.khweb.controller;

import com.mybang.khweb.controller.session.UserInfo;
import com.mybang.khweb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j



public class MemberController {
    private UserInfo info;

    @Autowired
    private MemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public Object jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        boolean checkId = false;
        checkId = service.checkDuplicateId(memberRequest.getUserId());

        if(checkId == true) {
            log.info("success");
            log.info(memberRequest.getUserId());
            service.register(memberRequest);
            return new ResponseEntity<Boolean>(HttpStatus.OK);
        }else {
            log.info("duuplicate");
            log.info(memberRequest.getUserId());
            return false;
        }

    }

}
