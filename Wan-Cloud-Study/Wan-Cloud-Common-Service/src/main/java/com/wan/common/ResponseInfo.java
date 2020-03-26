package com.wan.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ResponseInfo<T> {
    private static final Logger logger = LoggerFactory.getLogger(ResponseInfo.class);
    /**
     * 错误码
     */
    private String code = ErrorCode.CODE_SUCCESS;

    /**
     * 错误描述
     */
    private String desc = ErrorCode.DESC_SUCCESS;

    /**
     * 接口返回数据
     */
    private T data;

    /**
     * 推送错误数据
     */
    private Object pushError;

    /**
     * 数据版本号
     */
    private long dv;

    /**
     * 错误编号， 唯一
     */
    private String errorSN;

    public ResponseInfo() {

    }

    public ResponseInfo(String code) {
        setCode(code);
    }

    public Object getPushError() {
        return pushError;
    }

    public void setPushError(Object pushError) {
        this.pushError = pushError;
    }

    public long getDv() {
        return dv;
    }

    public void setDv(long dv) {
        this.dv = dv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        switch (code)
        {
            case ErrorCode.CODE_ILLEGAL_OPERATE:
                desc = ErrorCode.DESC_ILLEGAL_OPERATE;
                break;
            case ErrorCode.CODE_NO_SUCH_SOURCE:
                desc = ErrorCode.DESC_NO_SUCH_SOURCE;
                break;
            case ErrorCode.CODE_OTHER_ERROR:
                desc = ErrorCode.DESC_OTHER_ERROR;
                break;
            case ErrorCode.CODE_REQUEST_PARAM_INVALID:
                desc = ErrorCode.DESC_REQUEST_PARAM_INVALID;
                break;
            case ErrorCode.CODE_SIGN_INVALID:
                desc = ErrorCode.DESC_SIGN_INVALID;
                break;
            case ErrorCode.CODE_SUCCESS:
                desc = ErrorCode.DESC_SUCCESS;
                break;
            case ErrorCode.CODE_SUCH_SOURCE_EXIT:
                desc = ErrorCode.DESC_SUCH_SOURCE_EXIT;
                break;
            case ErrorCode.CODE_TOKEN_INVALID:
                desc = ErrorCode.DESC_TOKEN_INVALID;
                break;
            default:
                break;
        }
    }


    private static void printErrorLog(String code, String errorSN, HttpServletRequest request, String body)
    {
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put("code", code);
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement().toLowerCase();
            logMap.put(name, request.getHeader(name));
        }
        logMap.put("servletPath", request.getServletPath());
        logMap.put("method", request.getMethod());
        logMap.put("body", body);
        logger.error( JSON.toJSONString(logMap));
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorSN() {
        return errorSN;
    }

    public void setErrorSN(String errorSN) {
        this.errorSN = errorSN;
    }

    @Override
    public String toString() {
        return "ResponseInfo [code=" + code + ", desc=" + desc + ", data=" + data + "]";
    }

}
