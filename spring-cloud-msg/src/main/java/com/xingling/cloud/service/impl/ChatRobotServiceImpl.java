package com.xingling.cloud.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingling.cloud.dto.robot.*;
import com.xingling.cloud.enums.robot.MsgTypeEnum;
import com.xingling.cloud.exception.BusinessException;
import com.xingling.cloud.model.domain.Message;
import com.xingling.cloud.service.ChatRobotService;
import com.xingling.service.mybatis.impl.BaseServiceImpl;
import com.xingling.util.StringUtils;
import com.xingling.util.ValidatorUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>Title:	  koala-umc <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/5/15 13:50
 */
@Service
public class ChatRobotServiceImpl extends BaseServiceImpl<Message> implements ChatRobotService {

    private static Logger logger = LoggerFactory.getLogger(ChatRobotServiceImpl.class);

    @Override
    public boolean sendChatRobotMsg(ChatRobotMsgDto chatRobotMsgDto){
        logger.info("sendChatRobotMsg - 钉钉机器人开始发送消息. uamUserReqDto = {}", chatRobotMsgDto);
        boolean result = false;
        checkChatReBotMsg(chatRobotMsgDto);
        try {
            HttpClient httpclient = HttpClients.createDefault();
            String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=" + chatRobotMsgDto.getWebhookToken();
            HttpPost httpPost = new HttpPost(WEBHOOK_TOKEN);
            ObjectMapper mapper = new ObjectMapper();
            String robotJson = mapper.writeValueAsString(chatRobotMsgDto);
            logger.info("robotJson = {}", robotJson);
            httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
            StringEntity se = new StringEntity(robotJson, "utf-8");
            httpPost.setEntity(se);
            logger.info("robotJson={}", robotJson);
            logger.info("httpPost={}", httpPost);
            HttpResponse response = httpclient.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                logger.info("钉钉机器人发送消息成功 response={}", response);
                result = true;
            } else {
                logger.error("钉钉机器人发送消息失败 response={}", response);
                result = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * <p>Title:      checkChatReBotMsg. </p>
     * <p>Description 校验消息体</p>
     *
     * @param       chatRobotMsgDto  ChatRobotMsgDto
     * @return      void
     * @Author        <a href="190332447@qq.com"/>杨文生</a>
     * @since     2017/12/27 17:23
     */
    private void checkChatReBotMsg(ChatRobotMsgDto chatRobotMsgDto) {

        if (chatRobotMsgDto == null) {
            throw new BusinessException("钉钉机器人消息体为空");
        }
        String webhookToken = chatRobotMsgDto.getWebhookToken();
        String msgType = chatRobotMsgDto.getMsgType();
        if (StringUtils.isEmpty(webhookToken)) {
            throw new BusinessException("钉钉机器人token为空");
        }

        if (StringUtils.isEmpty(msgType)) {
            throw new BusinessException("钉钉机器人消息类型为空");
        }

        if (MsgTypeEnum.MARKDOWN.getName().equals(msgType)) {
            MarkdownDto markdown = chatRobotMsgDto.getMarkdown();
            String text = markdown.getText();
            String title = markdown.getTitle();
            if (StringUtils.isEmpty(markdown)) {
                throw new BusinessException("markdown类型消息体为空");
            }
            if (StringUtils.isEmpty(text)) {
                throw new BusinessException("markdown文档内容为空");
            }
            if (StringUtils.isEmpty(title)) {
                throw new BusinessException("markdown文档标题为空");
            }

        } else if (MsgTypeEnum.LINK.getName().equals(msgType)) {
            LinkDto link = chatRobotMsgDto.getLink();
            String text = link.getText();
            String title = link.getTitle();
            String messageUrl = link.getMessageUrl();
            if (StringUtils.isEmpty(link)) {
                throw new BusinessException("link类型消息体空");
            }
            if (StringUtils.isEmpty(text)) {
                throw new BusinessException("link文档内容为空");
            }
            if (StringUtils.isEmpty(title)) {
                throw new BusinessException("link文档标题为空");
            }
            if (StringUtils.isEmpty(messageUrl)) {
                throw new BusinessException("link文档点击消息跳转的URL空");
            }

        } else if (MsgTypeEnum.TEXT.getName().equals(msgType)) {
            TextDto text = chatRobotMsgDto.getText();
            AtDto at = chatRobotMsgDto.getAt();
            String content = text.getContent();

            if (StringUtils.isEmpty(text)) {
                throw new BusinessException("text类型消息体空");
            }
            if (StringUtils.isEmpty(content)) {
                throw new BusinessException("text类型消息体内容为空");
            }
            if (StringUtils.isNotEmpty(at)) {
                String[] atMobiles = at.getAtMobiles();
                if (StringUtils.isNotEmpty(atMobiles)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    //校验手机号码是否存在(由于钉钉和Pass平台用户未打通,所以这里不校验手机号码时候真实存在于系统中)
                    for (String atMobile : atMobiles) {
                        if (!ValidatorUtil.isMobile(atMobile)) {
                            stringBuilder.append(atMobile).append(" ");
                        }
                    }
                    if (stringBuilder.length() > 0) {
                        throw new BusinessException("手机号码:" + stringBuilder.toString() + "格式错误");
                    }
                }
            }

        } else {
            throw new BusinessException("钉钉机器人消息类型错误");
        }
    }
}
