package com.gara.sbcommon.exception;

import com.alibaba.fastjson.JSON;
import com.gara.sbcommon.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.slf4j.event.Level.ERROR;
import static org.slf4j.event.Level.WARN;


/**
* @Description:    全局异常处理
* @CreateDate:     2019-04-13 14:18
 * @Version:        1.0
*/
@RestControllerAdvice
public class GlobalHttpExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalHttpExceptionHandler.class);

    //处理系统内置的Exception
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Map<String, Object>> exception(HttpServletRequest request, Throwable ex) {
        return handleError(request, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, HttpMediaTypeException.class})
    public ResponseEntity<Map<String, Object>> badRequest(HttpServletRequest request,
                                                          ServletException ex) {
        return handleError(request, ResultCode.FAIL.code(), ex, WARN);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<Map<String, Object>> restTemplateException(HttpServletRequest request,
                                                                     HttpStatusCodeException ex) {
        return handleError(request, ex.getStatusCode().value(), ex);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> accessDeny(HttpServletRequest request,
                                                          AccessDeniedException ex) {
        return handleError(request, HttpStatus.FORBIDDEN.value(), ex);
    }

    //处理自定义Exception
    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<Map<String, Object>> badRequest(HttpServletRequest request, ApplicationException ex) {
        return handleError(request, ex.getCode().code(), ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException ex
    ) {
        final Optional<ObjectError> firstError = ex.getBindingResult().getAllErrors().stream().findFirst();
        if (firstError.isPresent()) {
            final String firstErrorMessage = firstError.get().getDefaultMessage();
            return handleError(request, ResultCode.VALIDATE_ERROR.code(), new ValidateException(firstErrorMessage),ERROR);
        }
        return handleError(request, ResultCode.VALIDATE_ERROR.code(), ex,ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(
            HttpServletRequest request, ConstraintViolationException ex
    ) {
        return handleError(request, ResultCode.VALIDATE_ERROR.code(), new ValidateException(ex.getMessage()));
    }

    private ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request,
                                                            int status, Throwable ex) {
        return handleError(request, status, ex, ERROR);
    }

    private ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request,
                                                            int status, Throwable ex, Level logLevel) {
        String message = ex.getMessage();
        printLog(message, ex, logLevel);

        Map<String, Object> errorAttributes = new HashMap<>();
        boolean errorHandled = false;

        if (ex instanceof HttpStatusCodeException) {
            try {
                //try to extract the original error info if it is thrown from apollo programs, e.g. admin service
                //errorAttributes = gson.fromJson(((HttpStatusCodeException) ex).getResponseBodyAsString(), mapType);

                //JSONObject.parseObject(((HttpStatusCodeException) ex).getResponseBodyAsString(),);

                errorAttributes = JSON.parseObject(((HttpStatusCodeException) ex).getResponseBodyAsString(), Map.class);
                status = ((HttpStatusCodeException) ex).getStatusCode().value();
                errorHandled = true;
            } catch (Throwable th) {
                //ignore
            }
        }

        if (!errorHandled) {
            errorAttributes.put("code", status);
            errorAttributes.put("message", message);
            errorAttributes.put("success", Boolean.FALSE);
            errorAttributes.put("data",null);
//            errorAttributes.put("timestamp",
//                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//            errorAttributes.put("exception", ex.getClass().getName());
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(errorAttributes, headers, HttpStatus.OK);
    }

    //打印日志, 其中logLevel为日志级别: ERROR/WARN/DEBUG/INFO/TRACE
    private void printLog(String message, Throwable ex, Level logLevel) {
        switch (logLevel) {
            case ERROR:
                logger.error(message, ex);
                break;
            case WARN:
                logger.warn(message, ex);
                break;
            case DEBUG:
                logger.debug(message, ex);
                break;
            case INFO:
                logger.info(message, ex);
                break;
            case TRACE:
                logger.trace(message, ex);
                break;
        }

        //Tracer.logError(ex);
    }
}
