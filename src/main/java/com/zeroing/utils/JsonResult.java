package com.zeroing.utils;

/**
 * @Author: lindec
 * @Email:lindec@163.com
 * @Date: 下午2:15 2018/5/15 Created with Intellij IDEA
 * @Description:
 */
public class JsonResult<T> {


    /**
     * 返回200表示有正确结果返回，其他皆为错误码（错误码可取不同定义）
     */
    private final int code;

    private final T data;

    /**
     * 错误原因描述
     */
    private final String desc;

    private JsonResult(JsonResultBuilder<T> builder) {
        this.code = builder.code;
        this.data = builder.data;
        this.desc = builder.desc;
    }

    public static <T> JsonResult.JsonResultBuilder<T> builder() {
        return new JsonResultBuilder<T>();
    }


    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", data=" + data +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static final class JsonResultBuilder<T> {


        private int code;

        private T data;

        private String desc;

        private JsonResultBuilder() {

        }

        /**
         * 错误时，返回错误原因描述
         *
         * @param code
         * @param desc
         * @return
         */
        public JsonResultBuilder error(int code, String desc) {
            this.code = code;
            this.desc = desc;
            return this;
        }

        /**
         * 返回正确数据
         *
         * @param data
         * @return
         */
        public JsonResultBuilder data(T data) {
            this.code = 200;
            this.data = data;
            this.desc = "success";
            return this;
        }

        public JsonResultBuilder data(int code, T data, String desc) {
            this.code = code;
            this.data = data;
            this.desc = desc;
            return this;
        }

        public JsonResult build() {
            return new JsonResult<T>(this);
        }
    }
//    public static void main(String[] args) {
//        System.out.print(JsonResult.<String>builder().data("asd").error("no error").build().toString());
//    }

}
