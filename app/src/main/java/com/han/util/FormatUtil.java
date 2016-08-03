package com.han.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hector Han on 2/25/2016.
 * TODO:FormatUtil String for Time/Money/Distance
 */


public class FormatUtil {
    /**
     * MM/dd/yyyy hh:mma
     * 2/25/2016 12:00 PM
     *
     * @return
     */
    public static String getTimeString(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mma");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * MM/dd/yyyy
     * 2/25/2016
     *
     * @return
     */
    public static String getCurTimeStringMDY(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * MM-dd-yyyy
     * 2/25/2016
     *
     * @return
     */
    public static String getLogFileTime(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * MM-dd-yyyy hh:mma
     * 2/25/2016 12:00 PM
     *
     * @return
     */
    public static String getCrashFileTime(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mma");
        return sdf.format(new Date(milliseconds));
    }

    public static String getBigDecimalString(BigDecimal decimal) {
        return new DecimalFormat(",###").format(decimal);
    }

    public static String getBigDecimalString(String decimal) {
        return new DecimalFormat(",###").format(new BigDecimal(decimal.replaceAll(",", "")));
    }

    /* 邮箱正则 */
    public static final String REG_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    public static boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        Pattern pattern = Pattern.compile(REG_EMAIL);
        Matcher matcher = pattern.matcher(email);
//        return email.contains("@");
        return matcher.matches();
    }

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 6;
    }


    public static String getMDFormatString(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MM/dd", Locale.US);
        return sdf.format(new Date(milliseconds));
    }


    public static String getEEEFormatString(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("EEE", Locale.US);
        return sdf.format(new Date(milliseconds));
    }

    public static String getMMMddFormatString(Long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("MMM dd", Locale.US);
        return sdf.format(new Date(milliseconds));
    }

    public static String getMMMddFormatString(String date) {
        DateFormat sdf = new SimpleDateFormat("MMM dd", Locale.US);
        return sdf.format(new Date(date));
    }

    public static String getHomeListItmeTimeString(long milliseconds) {
        DateFormat sdf = new SimpleDateFormat("M/d\nEEE", Locale.US);
        return sdf.format(new Date(milliseconds));
    }

    public static String getEEEMMMddFormatString(long date) {
        DateFormat sdf = new SimpleDateFormat("EEE MMM d", Locale.US);
        return sdf.format(new Date(date));
    }

    public static String getMMMMdFormatString(long date) {
        DateFormat sdf = new SimpleDateFormat("MMMM d", Locale.US);
        return sdf.format(new Date(date));
    }
}
