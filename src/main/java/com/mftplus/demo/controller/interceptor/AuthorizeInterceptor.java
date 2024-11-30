package com.mftplus.demo.controller.interceptor;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.controller.interceptor.annotation.Loggable;
import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.service.UserService;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.security.enterprise.SecurityContext;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.Set;

@Authorize
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Slf4j
public class AuthorizeInterceptor {
    @Inject
    private SecurityContext securityContext;

    @Inject
    private UserService userService;

    @AroundInvoke
    public Object logMethodCall(InvocationContext context) throws Exception {
        try {
            String authority = context.getMethod().getAnnotation(Authorize.class).authority();
            String username = securityContext.getCallerPrincipal().getName();
            Set<Permission> permissionSet = userService.findPermissionsByUsername(username);
            if(permissionSet != null && permissionSet.contains(authority)) {
                return context.proceed();
            }
            else{
                throw new AccessDeniedException("You Have Not Access To This Method !!!");
            }
        } finally {
            log.info(String.format("Method %s Finished -", context.getMethod().getName()));
        }
    }
}