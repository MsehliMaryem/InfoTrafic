package com.ant.technology.infotrafic.aop;

import javax.mail.MessagingException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAbonnee;
import com.ant.technology.infotrafic.utils.SendEmail;

@Aspect
@Configuration
public class AspectEmail {

	@AfterReturning(value = "execution(* com.ant.technology.infotrafic.services.impl.AbonneServiceImpl.save(..))", returning = "response")
	public void after(JoinPoint joinPoint, StringResponse response) {

		System.out.println(response.getMessage());
		if (response instanceof StringResponseAbonnee) {
			if (response.isSuccess()) {
				String code = ((StringResponseAbonnee) response).getCode();
				String email = ((StringResponseAbonnee) response).getEmail();

				String subject = "Code d'activation";
				String object = "Merci d'introduire votre  code est :"+code;
				try {
					SendEmail.envoyerEmail(email, subject, object);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 

	}

}
