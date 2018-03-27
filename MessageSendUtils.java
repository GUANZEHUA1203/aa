package com.stkj.pperty.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.stkj.pperty.common.SystemConfig;


/**
 * @author HUANGP
 * @date 2018年1月23日
 * @des 验证码发送
 */
public class MessageSendUtils {
    /**
     * @author HUANGP
     * @des 密码修改短信验证码发送
     * @date 2018年1月23日
     * @param phoneNo  电话号码
     * @param code 短信验证码
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendSmsUpdateLoginPassword(String phoneNo,String code) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", SystemConfig.defaultConnectTimeout);
        System.setProperty("sun.net.client.defaultReadTimeout",SystemConfig.defaultReadTimeout);
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", SystemConfig.accessKeyId, SystemConfig.accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", SystemConfig.product, SystemConfig.domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNo);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SystemConfig.signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(SystemConfig.templateCodeOfUpdateLoginPassword);
        //可选:模板中的变量替换JSON串,如模板内容为"您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+code+"\"}");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    public static void main(String[] args) throws ClientException, InterruptedException {

        //发短信
        SendSmsResponse response = sendSmsUpdateLoginPassword("15223576075","555555");
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

       

    }

}
