/**
 *
 */
package jp.co.sacn.util;

/**
 * @author gotoumasahiko
 *
 */
public class StringUtils {

    private StringUtils() {};

    /**
    * 文字列のnullチェック
    *
    * @param text 文字列
    * @return true/false
    */
    public static boolean isNull(String text) {
        if(text == null){
            return true;
        }
        if(text.isEmpty() || "".equals(text)){
            return true;
        }

        return false;
    }

    /**
    * 文字列のnullチェック
    *
    * @param text 文字列
    * @return true/false
    */
    public static boolean isNotNull(String text) {
    	return !isNull(text);
    }

    /**
    * 文字列の空チェック
    *
    * @param text 文字列
    * @return true/false
    */
    public static boolean isEmpty(String text) {
        return isNull(text);
    }

    /**
    * 文字列の空チェック
    *
    * @param text 文字列
    * @return true/false
    */
    public static boolean isNotEmpty(String text) {
        return isNotNull(text);
    }
}
