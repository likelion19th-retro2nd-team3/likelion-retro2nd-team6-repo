package com.members.정다희.labs.practice_251014;

import com.members.정다희.labs.practice_251014.config.UserConfig;
import com.members.정다희.labs.practice_251014.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserExam {
    public static void main(String[] args) {
        // 스프링 설정 파일(UserConfig.class)을 기반으로 컨테이너(ApplicationContext)를 생성한다.
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        // 스프링이 생성하고 관리하는 UserController 빈(객체)을 가져온다.
        UserController controller = context.getBean(UserController.class);
        // UserController의 joinUser() 메서드를 실행하여 Service → Repository 계층으로 흐름이 진행된다.
        controller.joinUser();
    }
}
