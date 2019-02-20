/**
 * 
 */
package utils.utils_1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.TreeMap;


/**
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
 * 确的浮点数运算，包括加减乘除和四舍五入。
 * @author EX-CHENPING002
 * @2014-1-27
 * @下午4:59:11
 * @TODO
 */
public class NumberUtils {

    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    //这个类不能实例化
    private NumberUtils() {
    }

    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        try {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.add(b2).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        try {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.subtract(b2).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        try {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.multiply(b2).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    // 两个数相乘
    public static String mul(String v1, double v2) {
        if (v1 == null || v1.trim().equals("")) {
            return "";
        }
        try {
            BigDecimal b1 = new BigDecimal(v1);
            BigDecimal b2 = new BigDecimal(Double.toString(v2));

            return String.valueOf(b1.multiply(b2).doubleValue());
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @param scale 保留位数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {

        try {
            BigDecimal b1 = BigDecimal.valueOf(v1);
            BigDecimal b2 = BigDecimal.valueOf(v2);

            return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    // 两数相乘,结果保留4位精度 
    public static double mul4(double v1, double v2) {
        return mul(v1, v2, 4);
    }

    /**
     * Double精度不够，可用BigDecimal避免
     * @param num1
     * @param num2
     * @return
     */
    public static BigDecimal add(BigDecimal num1, Double num2) {
        return num1.add(new BigDecimal(num2)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        try {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        try {
            BigDecimal b = new BigDecimal(Double.toString(v));
            BigDecimal one = new BigDecimal("1");
            return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception ex) {
            return Double.NaN;
        }
    }


    /**
     * 字符串转double
     * @param str
     * @return
     */
    public static double parseDouble(String str) {
        if (str == null)
            return 0;

        Double d = null;
        try {
            d = Double.valueOf(str);
        } catch (NumberFormatException ex) {
            return 0;
        }
        if (d.isNaN()) {
            return 0;
        } else {
            return d.doubleValue();
        }

    }

    /**
     * 字符串转short
     * @param str
     * @return
     */
    public static short parseShort(String str) {
        Double d = parseDouble(str);
        short shortValue = d.shortValue();
        return shortValue;
    }

    /**
     * 字符串转int
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        if (str == null)
            return 0;

        Integer integer = null;
        try {
            integer = Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return 0;
        }

        return integer.intValue();
    }
    /**
     * 字符串转Integer
     * @param str
     * @return
     */
    public static Integer parseInt1(String str) {
    	if (str == null){
    		return null;
    	}
    	try {
    		return Integer.valueOf(str);
    	} catch (NumberFormatException ex) {
    		return null;
    	}
    }
    /**
     * 根据TreeMap,取得MAP里面的最大值
     * 
     * @param tm
     *            TreeMap 可根据KE值,排序VALUES值
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Object getMaxValueFromMap(TreeMap tm) {
        if (null == tm || tm.size() < 1)
            return new Double(0);
        Object maxKey = tm.lastKey();
        return tm.get(maxKey);
    }

    /**
     * 两个double数比较大小，取小者 
     * （后期改造成：Object Object 数值进行比较，更加通用）
     * @param value1
     * @param value2
     * @return
     */
    public static double getMinValueTweenTwo(double value1, double value2) {
        return value1 < value2 ? value1 : value2;
    }


    /**
    * 科学计数法转换为正常格式显示
    * format=###########.###############
    */
    public static String parseToFormat(double ret, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return (df.format(ret));
    }

    public static double precisionParse(double ret, String format) {
        return Double.parseDouble(parseToFormat(ret, format));
    }

    /**
         * 将double转换成String
         * @param value
         * @return
         */
    public static String changeDoubleToStr(double value) {

        if (!isExist(value)) {
            return "";
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(value);
    }

    /**zxs 20121114
     * 将double转换成String
     * @param value
     * @return
     */
    public static String convertDoubleToStr(double value, String format) {
        if (Double.isNaN(value) || format == null) {
            return "";
        }
        DecimalFormat df = new DecimalFormat(format);
        return df.format(value);
    }

    /**
     * 将double转换成String
     * @param value
     * @return
     */
    public static String changeDoubleToStr(double value, String format) {
        if (!isExist(value) || format == null) {
            return "";
        }
        DecimalFormat df = new DecimalFormat(format);
        return df.format(value);
    }
    
    /**
     * 判断一个数值是否存在
     * 不存在条件如下：
     * 1. 不为 null
     * 2. 不为 NaN
     * @param num 需要验证的数值
     * @return
     */
    public static boolean isNotNull(Double num) {
        if (num == null)
            return false;
        if (Double.isNaN(num))
            return false;

        return true;
    }

    /**
     * 判断一个数值是否存在
     * 不存在条件如下：
     * 1. 不为 null
     * 2. 不为 NaN
     * 3. 不为 0
     * @param num 需要验证的数值
     * @return
     */
    public static boolean isExist(Double num) {
        if (num == null)
            return false;
        if (Double.isNaN(num))
            return false;
        if (num == 0)
            return false;

        return true;
    }

    /**
     * 判断一个数值是否存在
     * 不存在条件如下：
     * 1. 不为 null
     * 2. 不为 NaN
     * 3. 不为 0
     * @param num 需要验证的数值
     * @return
     */
    public static boolean isExist(Integer num) {
        if (num == null)
            return false;
        if (num == 0)
            return false;

        return true;
    }

    /**
     * 判断一个数值是否存在
     * 不存在条件如下：
     * 1. 不为 null
     * 2. 不为 NaN
     * 3. 不为 0
     * @param num 需要验证的数值
     * @return
     */
    public static boolean isExist(int num) {
        if (num == 0)
            return false;

        return true;
    }

    /**
     * 比较两个Double类型
     * @param num 需要验证的数值
     * @return
     */
    public static boolean isEqual(double num1, double num2) {
        BigDecimal b1 = new BigDecimal(Double.toString(num1));
        BigDecimal b2 = new BigDecimal(Double.toString(num2));

        if (b1.compareTo(b2) == 0)
            return true;
        else
            return false;
    }

    /**
     * 将double数据转成String并去掉小数点无效的0
     * @param b
     * @return
     */
    public static String removeTailZero(double num) {
        String numStr = String.format("%f", num);
        int i, len = numStr.length();
        for (i = 0; i < len; i++)
            if (numStr.charAt(len - 1 - i) != '0')
                break;
        if (numStr.charAt(len - i - 1) == '.')
            return numStr.substring(0, len - i - 1);
        return numStr.substring(0, len - i);
    }
    
    /**
     * 将Double转换成String
     * @param value
     * @return
     */
    public static String doubleToStr(Double value) {
        if (value == null || Double.isNaN(value)) {
        return null;
        }
        
        BigDecimal decimal = BigDecimal.valueOf(value);
        return decimal.toString();
    }
    
    /**
     * 字符串转Double
     * @param str
     * @return
     */
    public static Double parseDouble2(String str) {
	    if (str == null)
	        return null;
	    
	     Double d = null;
	    try {
	        d = Double.valueOf(str);
	    } catch (NumberFormatException ex) {
	        return null;
	    }
	    return d.isNaN() ? null : d;
    }
    
    /**
     * 将Double转换成String
     * @param value
     * @return
     */
    public static String doubleToStr2(Double value) {
        if (value == null || Double.isNaN(value)) {
        return null;
        }
        
        BigDecimal decimal = new BigDecimal(value);
        return decimal.toString();
    }
    
    /**
     * 将Integer转换成String
     * @param value
     * @return
     */
    public static String integerToStr(Integer value) {
        if (value == null) {
        return null;
        }
        
        BigDecimal decimal = BigDecimal.valueOf(value);
        return decimal.toString();
    }

}