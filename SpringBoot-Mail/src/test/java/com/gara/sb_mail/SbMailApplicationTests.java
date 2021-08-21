package com.gara.sb_mail;

import freemarker.template.Template;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SbMailApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void contextLoads() {
		Assertions.assertEquals("ss","ss");
	}

	public static final String sender = "mailgara@163.com";
	public static final String receiver = "mailgara@163.com";

	@Test
	public void sendSampleMail(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender);
		message.setTo(receiver);
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		mailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws Exception{

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		helper.setFrom(sender);
		helper.setTo(receiver);
		helper.setSubject("主题：有附件 ");
		helper.setText("这是一封有附件的邮件");

		FileDataSource file = new FileDataSource(new File("test.txt"));

		helper.addAttachment("附件-1.txt", file);
		helper.addAttachment("附件-2.txt", file);

		mailSender.send(mimeMessage);
	}
	
	/**
	 *  
	 * 邮件中嵌入静态资源
	 * @author Gary
	 * @date 2018/4/3 19:32
	 * @param []
	 * @return 
	 * @else 
	 *
	 */
	@Test
	public void sendInlineMail() throws Exception{

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

		helper.setFrom(sender);
		helper.setTo(receiver);
		helper.setSubject("主题：嵌入静态资源 ");

		helper.setText("<html><body><img src=\"cid:photoimg\" ></body></html>", true);

		FileDataSource file = new FileDataSource(new File("222.jpg"));
		helper.addInline("photoimg", file);

		mailSender.send(mimeMessage);

	}


	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;  //自动注入
	/**
	 *
	 * 模板邮件法发送
	 * @author Gary
	 * @date 2018/4/3 19:39
	 * @param []
	 * @return
	 * @else
	 *
	 */
	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(sender);
		helper.setTo(receiver);
		helper.setSubject("主题：模板邮件");

		Map<String, Object> model = new HashMap<>();
		model.put("username", "啵啵");

		Template template = freeMarkerConfigurer.getConfiguration().getTemplate("template.vm");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		helper.setText(html, true);

		mailSender.send(mimeMessage);
	}

}
