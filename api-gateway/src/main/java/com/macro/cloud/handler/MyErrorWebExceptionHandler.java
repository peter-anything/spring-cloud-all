package com.macro.cloud.handler;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;

import java.util.HashMap;
import java.util.Map;

public class MyErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {
    public MyErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
    }

    /**
     * 指定响应处理方法为JSON处理
     * @param errorAttributes
     * @return
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(),this::renderErrorResponse);
    }

//    /**
//     * 根据code获取对应的HttpStatus
//     * @param errorAttributes
//     * @return
//     */
//    @Override
//    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
//        return errorAttributes.get("status");
//    }

    /**
     * 构建异常信息
     * @param request
     * @param ex
     * @return
     */
    private String buildMessage(ServerRequest request, Throwable ex){
        StringBuilder builder = new StringBuilder("Failed to handle request:");
        builder.append(request.methodName());
        builder.append(" ");
        builder.append(request.uri());
        if (ex!=null){
            builder.append(ex.getMessage());
        }
        return builder.toString();
    }
    /**
     * 返回的json数据
     * @param status
     * @param errorMsg
     * @param data
     * @return
     */
    public static Map<String,Object> response(int status,String errorMsg,Object data){
        Map<String,Object> map=new HashMap<>();
        map.put("code",status);
        map.put("message",errorMsg);
        map.put("data",data);
        return map;
    }
}
