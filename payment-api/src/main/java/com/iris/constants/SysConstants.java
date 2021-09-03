package com.iris.constants;

/**
 * 系统常量
 *
 * @author chongwenjun
 */
public class SysConstants {
    // 分页-开始页数
    public static final int PAGE_START = 1;
    // 分页-每页显示行数
    public static final int PAGE_NUMS = 20;
    // 分页-显示行数
    public static final int PAGE_NUMS_FIFTY = 50;
    // 接口返回code
    public static final String REST_RETURN_CODE = "code";
    // 接口返回msg
    public static final String REST_RETURN_MSG = "msg";
    // 接口返回成功
    public static final String REST_RETURN_CODE_SUCCESS = "success";
    // 接口返回失败
    public static final String REST_RETURN_CODE_FAIL = "fail";
    // 接口返回失败消息信息-系统异常
    public static final String REST_RETURN_FAIL_MESSAGE = "系统异常";
    // 接口返回失败消息信息-错误提示
    public static final String REST_RETURN_ERROR_MESSAGE = "请求失败,请联系系统管理员";
    // Mysql数据苦衷删除标志位常量，已删除：1
    public static final String MYSQL_IS_DELETED_TRUE = "1";
    // Mysql数据苦衷删除标志位常量，未删除：0
    public static final String MYSQL_IS_DELETED_FALSE = "0";

};