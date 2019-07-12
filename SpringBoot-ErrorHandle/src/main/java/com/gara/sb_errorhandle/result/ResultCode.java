package com.gara.sb_errorhandle.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    FORBIDDEN(403),
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    // 通用错误以9开头
    APPLICATION_ERROR(9000),// 应用级错误
    VALIDATE_ERROR(9001),// 参数验证错误
    SERVICE_ERROR(9002),// 业务逻辑验证错误
    CACHE_ERROR(9003),// 缓存访问错误
    DAO_ERROR(9004);// 数据访问错误

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
