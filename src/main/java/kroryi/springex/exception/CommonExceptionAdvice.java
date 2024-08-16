package kroryi.springex.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> exceptNumber(NumberFormatException numberFormatException) {
        log.error("---------------------");
        log.error(numberFormatException.getMessage());

        String responseMsg= "NUMBER FORMAT EXCEPTION";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .body(new String(responseMsg.getBytes(), StandardCharsets.UTF_8));
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommo(Exception e) {
        log.error("---------------------");
        log.error(e.getMessage());

        StringBuffer buffer=new StringBuffer("<ul>");

        buffer.append("<li>").append(e.getMessage()).append("</li>");

        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }

}
