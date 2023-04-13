package com.bongsoo.backend.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

// lombok
@Getter
@Setter
@Builder
@ToString
// spring boot session data
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemberInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
}
