package com.xingling.cloud.enums.robot;

/**
 * <p>Title:      MsgTypeEnum. </p>
 * <p>Description 消息类型 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author         <a href="190332447@qq.com"/>杨文生</a>
 * @since      2017/12/12 16:58
 */
public enum MsgTypeEnum {
    /**
     * 操作日志
     */
    MARKDOWN("markdown", "markdown"),
	LINK("link", "link"),
	TEXT("text", "text"),
    ;

    String type;
    String name;

    MsgTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String type) {
        for (MsgTypeEnum ele : MsgTypeEnum.values()) {
            if (ele.getType().equals(type)){
	            return ele.getName();
            }
        }
        return null;
    }

}
