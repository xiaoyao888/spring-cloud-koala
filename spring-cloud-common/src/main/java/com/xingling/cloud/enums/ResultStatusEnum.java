package com.xingling.cloud.enums;


/**
 * User:frankwoo(吴峻申) <br>
 * Date:2016-11-3 <br>
 * Time:13:48 <br>
 * Mail:frank_wjs@hotmail.com <br>
 */
public enum ResultStatusEnum {
    OK(200, "成功"),
    PARAMETER_ERROR(10001, "参数错误"),
    DATA_QUERY_ERROR(10001, "查询数据失败"),
    DATA_UPDATED_ERROR(10002, "更新数据失败"),
    DATA_DELETED_ERROR(10003, "删除数据失败"),
    DATA_INPUT_ERROR(10004, "数据未输入"),
    INVALID_USER_NAME(10005, "用户名错误"),
    INVALID_PASSWORD(10006, "密码错误"),
    INVALID_TOKEN(10007, "access_token无效");

    // 成员变量
    private int code;
    private String message;

    /**
     * 构造方法
     *
     * @param code    错误码
     * @param message 错误消息
     */
    ResultStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return 返回成员变量值
     */
    public int getCode() {
        return code;
    }

    /**
     * @return 返回成员变量值
     */
    public String getMessage() {
        return message;
    }
}