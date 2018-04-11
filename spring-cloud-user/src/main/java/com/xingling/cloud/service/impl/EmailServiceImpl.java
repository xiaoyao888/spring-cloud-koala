package com.xingling.cloud.service.impl;

import com.xingling.cloud.config.email.EmailConfig;
import com.xingling.cloud.service.EmailService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>Title:	  EmailServiceImpl <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/8/30 11:40
 */

@Service
public class EmailServiceImpl implements EmailService {

	public static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private EmailConfig emailConfig;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean sender(String to, String subject, String content) {
		return sender(to, subject, content, true);
	}

	@Override
	public boolean sender(String to, String subject, String content, boolean html) {
		if (StringUtils.isBlank(to)) {
			logger.error("邮件发送失败：收件人地址不能为空.");
			return false;
		}
		return sender(new String[]{to}, subject, content, html);
	}

	@Override
	public boolean sender(String[] to, String subject, String content, boolean html) {
		if (to == null || to.length == 0) {
			logger.error("批量邮件发送失败：收件人地址不能为空.");
			return false;
		}

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailConfig.getDefaultFrom());
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);

		try {
			javaMailSender.send(simpleMailMessage);
			return true;
		} catch (MailException e) {
			logger.error("发送邮件错误：{}, TO:{}, Subject:{},Content:{}.", e, to, subject, content);
			return false;
		}
	}
}
