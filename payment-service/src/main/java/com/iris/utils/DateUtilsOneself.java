package com.iris.utils;

import com.iris.common.exception.BizException;
import com.iris.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2019/5/16.
 */
public class DateUtilsOneself {


    /**
     * 2018-09-01 11:00:23 ---->2018-09-01 00:00:00
     *
     * @param date
     * @throws BizException
     */
    public static String dateFormatStart(String date) throws BizException {
        if(StringUtils.isBlank(date)) return null;
        return DateUtil.getDateTimeFormat(DateUtil.getStartOfDay(DateUtil.getDateFormat(date)));
    }

    /**
     * 2018-09-01 11:00:23 ---->2018-09-01 23:59:59
     * @param date
     * @return
     * @throws BizException
     */
    public static String dateFormatEnd(String date) throws BizException {
        if(StringUtils.isBlank(date)) return null;
        return DateUtil.getDateTimeFormat(DateUtil.getEndOfDay(DateUtil.getDateFormat(date)));
    }
}
