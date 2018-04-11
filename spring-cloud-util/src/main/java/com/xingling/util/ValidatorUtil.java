package com.xingling.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title:	  ValidatorUtil. </p>
 * <p>Description java验证工具类 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/4/19 12:05
 */
public class ValidatorUtil {
    /**
     * 是否是整数
     *
     * @param value
     */
    public static boolean isIntege(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^-?[1-9]\\d*$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是正整数
     *
     * @param value
     */
    public static boolean isIntege1(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[1-9]\\d*$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是负整数
     *
     * @param value
     */
    public static boolean isIntege2(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^-[1-9]\\d*$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是数字
     *
     * @param value
     */
    public static boolean isNum(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^([+-]?)\\d*\\.?\\d+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是正数（正整数 + 0）
     *
     * @param value
     */
    public static boolean isNum1(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[1-9]\\d*|0$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是负数（负整数 + 0）
     *
     * @param value
     */
    public static boolean isNum2(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^-[1-9]\\d*|0$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是浮点数
     *
     * @param value
     */
    public static boolean isDecmal(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^([+-]?)\\d*\\.\\d+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是正浮点数
     *
     * @param value
     */
    public static boolean isDecmal1(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是负浮点数
     *
     * @param value
     */
    public static boolean isDecmal2(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是浮点数
     *
     * @param value
     */
    public static boolean isDecmal3(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是非负浮点数（正浮点数 + 0）
     *
     * @param value
     */
    public static boolean isDecmal4(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是非正浮点数（负浮点数 + 0）
     *
     * @param value
     */
    public static boolean isDecmal5(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是邮件
     *
     * @param value
     */
    public static boolean isEmail(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 是否是颜色
     *
     * @param value
     */
    public static boolean isColor(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[a-fA-F0-9]{6}$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是url
     *
     * @param value
     */
    public static boolean isUrl(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是中文
     *
     * @param value
     */
    public static boolean isChinese(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是ACSII字符
     *
     * @param value
     */
    public static boolean isAscii(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[\\x00-\\xFF]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是邮编
     *
     * @param value
     */
    public static boolean isZipcode(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^\\d{6}$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是手机
     *
     * @param value
     */
    public static boolean isMobile(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^(13|15)[0-9]{9}$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 验证手机号码
     *
     * @param mobileNumber String
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 是否是ip地址
     *
     * @param value
     */
    public static boolean isIp(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是非空
     *
     * @param value
     */
    public static boolean isNotempty(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^\\S+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是图片
     *
     * @param value
     */
    public static boolean isPicture(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是压缩文件
     *
     * @param value
     */
    public static boolean isRar(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("(.*)\\.(rar|zip|7zip|tgz)$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是日期
     *
     * @param value
     */
    public static boolean isDate(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是QQ号码
     *
     * @param value
     */
    public static boolean isQq(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[1-9]*[1-9][0-9]*$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是电话号码的函数(包括验证国内区号,国际区号,分机号)
     *
     * @param value
     */
    public static boolean isTel(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     *
     * @param value
     */
    public static boolean isUsername(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^\\w+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是字母
     *
     * @param value
     */
    public static boolean isLetter(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[A-Za-z]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是大写字母
     *
     * @param value
     */
    public static boolean isLetter_u(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[A-Z]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是大写字母
     *
     * @param value
     */
    public static boolean isLetter_l(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^[a-z]+$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

    /**
     * 是否是价格
     *
     * @param value
     */
    public static boolean isPrice(String value) {
        Pattern p = null;//正则表达式
        Matcher m = null;//操作符表达式
        boolean b = false;
        p = p.compile("^([1-9]{1}[0-9]{0,}(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|\\.[0-9]{1,2})$");
        m = p.matcher(value);
        b = m.matches();
        return b;
    }

}