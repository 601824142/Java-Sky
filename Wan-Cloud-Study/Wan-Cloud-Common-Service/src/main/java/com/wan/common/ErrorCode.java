package com.wan.common;

public interface ErrorCode {

    /**
     * 成功
     */
    String CODE_SUCCESS = "000001";
    String DESC_SUCCESS = "success";

    /**
     * 其他错误
     */
     String CODE_OTHER_ERROR = "000002";
     String DESC_OTHER_ERROR = "Other error happened.";

    /**
     * 证书非法
     */
     String CODE_TOKEN_INVALID = "000003";
     String DESC_TOKEN_INVALID = "The token is invalid.";

    /**
     * 签名非法
     */
     String CODE_SIGN_INVALID = "000004";
     String DESC_SIGN_INVALID = "The sign is invalid.";

    /**
     * 该资源不存在
     */
     String CODE_NO_SUCH_SOURCE = "000005";
     String DESC_NO_SUCH_SOURCE = "No such source exists.";

    /**
     * 该资源已经存在
     */
     String CODE_SUCH_SOURCE_EXIT = "000006";
     String DESC_SUCH_SOURCE_EXIT = "such source exists.";

    /**
     * 请求参数非法
     */
     String CODE_REQUEST_PARAM_INVALID = "000007";
     String DESC_REQUEST_PARAM_INVALID = "request parameter is invalid.";

    /**
     * 操作非法
     */
     String CODE_ILLEGAL_OPERATE = "000008";
     String DESC_ILLEGAL_OPERATE = "illegal operation.";

    /**
     * 临时错误码
     */
     String CODE_TEMP = "000017";
     String DESC_TEMP = "temp.";








}
