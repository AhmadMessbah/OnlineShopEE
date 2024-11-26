package com.mftplus.demo.controller.interceptor;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@ResponseMaker
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ResponseMakerInterceptor {
    @AroundInvoke
    public Object responseMaker(InvocationContext context) throws Exception {
        try {
            Object result = context.proceed(); //when the method is calling!
            if (context.getMethod().getAnnotation(POST.class) != null) {
                return Response.status(Response.Status.CREATED).entity(result).build();
            }
            if (result == null || result instanceof List<?> && ((List<?>) result).isEmpty()) {
                return Response.noContent().build();
            }
//            return Response.ok(result).build();
            if (context.getMethod().getAnnotation(DELETE.class) != null) {
                return Response.noContent().build();
            }
            return Response.ok(result).build();

        } catch (Throwable e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("Error-Type :", e.getClass(), "Message :", e.getMessage()))
                    .build();
        }
    }
}
