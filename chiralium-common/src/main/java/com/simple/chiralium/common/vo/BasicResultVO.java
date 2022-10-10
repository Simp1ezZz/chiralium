package com.simple.chiralium.common.vo;

import com.simple.chiralium.common.enums.RespStatusEnum;
import lombok.*;

/**
 * 统一请求响应VO
 *
 * @author simpleZzz
 * @date 2022/10/08 10:02:24
 */
@ToString(callSuper = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class BasicResultVO<T> {

    /**
     * 响应状态
     */
    private String status;

    /**
     * 响应编码
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public BasicResultVO(RespStatusEnum status, String msg, T data) {
        this.status = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    public BasicResultVO(RespStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public BasicResultVO(RespStatusEnum status) {
        this(status, null);
    }

    /**
     * 默认响应成功方法
     *
     * @return {@link BasicResultVO}<{@link Void}>
     */
    public static <T> BasicResultVO<T> success() {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS);
    }

    /**
     * 自定义消息的响应成功方法
     *
     * @param msg 响应消息
     * @return {@link BasicResultVO}<{@link T}>
     */
    public static <T> BasicResultVO<T> success(String msg) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, msg, null);
    }

    /**
     * 带数据的响应成功方法
     *
     * @param data 数据
     * @return {@link BasicResultVO}<{@link T}>
     */
    public static <T> BasicResultVO<T> success(T data) {
        return new BasicResultVO<>(RespStatusEnum.SUCCESS, data);
    }

    /**
     * 默认响应失败方法
     *
     * @return {@link BasicResultVO}<{@link T}>
     */
    public static <T> BasicResultVO<T> fail() {
        return new BasicResultVO<>(RespStatusEnum.FAIL);
    }

    /**
     * 自定义信息的响应失败方法
     *
     * @param msg 响应信息
     * @return {@link BasicResultVO}<{@link T}>
     */
    public static <T> BasicResultVO<T> fail(String msg) {
        return new BasicResultVO<>(RespStatusEnum.FAIL, msg, null);
    }

    /**
     * 带有返回数据的响应失败方法
     *
     * @param data 数据
     * @return {@link BasicResultVO}<{@link T}>
     */
    public static <T> BasicResultVO<T> fail(T data){
        return new BasicResultVO<>(RespStatusEnum.FAIL,data);
    }
}
