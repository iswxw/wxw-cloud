package com.wxw.manage.filter;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * @author weixiaowei
 * @desc:
 * @date: 2021/6/29
 */
@Configuration
public class TraceFilter implements Filter {

    /**
     * 跟踪 traceId
     */
    private static final String TRACE_ID = "traceId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            String traceId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            MDC.put(TRACE_ID,traceId);
            filterChain.doFilter(servletRequest,servletResponse);
        } finally {
            if (Objects.nonNull(MDC.get(TRACE_ID))){
                MDC.remove(TRACE_ID);
            }
        }
    }
}
