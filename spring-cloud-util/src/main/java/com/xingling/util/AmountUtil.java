package com.xingling.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>Title:	  AmountUtil. </p>
 * <p>Description 金额换算工具类 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/6/2 13:09
 */
public class AmountUtil {

	 /**金额为分的格式 */    
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";    
    
    private static final int PARSE_SCALE = 2;
    
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
    
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("92233720368547758.07");  //最大金额
    
    /**
     * 计算利率
     * rate/base
     * @param rate 利率
     * @param base 基数
     * @return
     */
    public static BigDecimal rate(Long rate, Long base){
    	BigDecimal r = new BigDecimal(rate);
    	BigDecimal b = new BigDecimal(base);
    	return r.divide(b,2,RoundingMode.HALF_UP);
    }
    
    /**
     * 判断是否为 100元整数
     * @param amount 分
     * @return
     */
    public static boolean isWhole(Long amount){
    	if(amount < 10000){
    		return false;
    	}
    	if(amount % 10000 == 0){
    		return true;
    	}
    	return false;
    }
    
    /**
     * 是否为正确金额
     * @param amount
     * @return
     */
    public static boolean isAmount(BigDecimal amount){
    	if(MAX_AMOUNT.compareTo(amount) < 0){
    		return false;
    	}
    	return true;
    }
    
    /**
     * 分转元
     * @param amount
     * @return
     * @throws Exception
     */
    public static BigDecimal changeF2Y(Long amount) throws Exception{
    	return new BigDecimal(amount).divide(new BigDecimal(100));
    }
    
    /**
     * 将元为单位的转换为分 （乘100）
     * @param amount
     * @return
     */
    public static Long changeY2F(BigDecimal amount){
    	return amount.movePointRight(PARSE_SCALE).setScale(0, DEFAULT_ROUNDING).longValue();    
    }
        
    /**   
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）  
     *   
     * @param amount  
     * @return  
     * @throws Exception   
     */  
    @Deprecated
    public static String changeF2YStr(Long amount) throws Exception{    
        if(!amount.toString().matches(CURRENCY_FEN_REGEX)) {    
            throw new Exception("金额格式有误");    
        }    
            
        int flag = 0;    
        String amString = amount.toString();    
        if(amString.charAt(0)=='-'){    
            flag = 1;    
            amString = amString.substring(1);    
        }    
        StringBuffer result = new StringBuffer();    
        if(amString.length()==1){    
            result.append("0.0").append(amString);    
        }else if(amString.length() == 2){    
            result.append("0.").append(amString);    
        }else{    
            String intString = amString.substring(0,amString.length()-2);    
            for(int i=1; i<=intString.length();i++){    
//                if( (i-1)%3 == 0 && i !=1){    
//                    result.append(",");    
//                }    
                result.append(intString.substring(intString.length()-i,intString.length()-i+1));    
            }    
            result.reverse().append(".").append(amString.substring(amString.length()-2));    
        }    
        if(flag == 1){    
            return "-"+result.toString();    
        }else{    
            return result.toString();    
        }    
    }  
    
   
        
    /**  
     * 将分为单位的转换为元 （除100）  
     *   
     * @param amount  
     * @return  
     * @throws Exception   
     */    
    @Deprecated
    public static String changeF2Y(String amount) throws Exception{    
        if(!amount.matches(CURRENCY_FEN_REGEX)) {    
            throw new Exception("金额格式有误");    
        }    
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString();    
    }    
        
    /**   
     * 将元为单位的转换为分 （乘100）  
     *   
     * @param amount  
     * @return  
     */  
    @Deprecated
    public static String changeY2F(Long amount){    
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();    
    }   
    
        
    /**   
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额  
     *   
     * @param amount  
     * @return  
     */    
   @Deprecated
   public static Long changeY2F(String amount){    
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额    
        int index = currency.indexOf(".");    
        int length = currency.length();    
        Long amLong = 0l;    
        if(index == -1){    
            amLong = Long.valueOf(currency+"00");    
        }else if(length - index >= 3){    
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));    
        }else if(length - index == 2){    
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);    
        }else{    
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");    
        }    
        return amLong;    
    }
}
