package bgw.board.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@Component
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filterInit");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        StringBuilder builder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().substring(0,8);
        builder.append("[").append(uuid).append("] ip : ").append(request.getRemoteAddr());
        builder.append(": start : ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        log.info(builder.toString());
        builder = null;
        builder = new StringBuilder();
        builder.append("[").append(uuid).append("] ip : ").append(request.getRemoteAddr());
        builder.append(": end : ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        chain.doFilter(request,response);
        log.info(builder.toString());

    }


    @Override
    public void destroy() {
        log.info("log destroy");
        Filter.super.destroy();
    }





}
