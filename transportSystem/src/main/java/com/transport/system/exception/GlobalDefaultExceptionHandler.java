package com.transport.system.exception;


import com.transport.system.dao.ScheduleDaoIml;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Controller for management exceptions
 *
 * @version 1.0
 * @autor Artem
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler  {

    private static final Logger logr = Logger.getLogger(ScheduleDaoIml.class);
    /**
     * Controller for going beyond the site exception
     * @return ModelAndView
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException() {

        ModelAndView mv = new ModelAndView("404");

        logr.info("*****Exception*****was happnd 404");
        mv.addObject("title", "404 OOPSS");
        return mv;
    }

    /**
     * Controller for unexpected exception in application
     *
     * @param e - unexpected Exception in application
     * @return ModelAndView
     */

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e) {

        ModelAndView mv = new ModelAndView("404");

        //for debag
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        e.printStackTrace(pw);
        // end debug
        logr.info("*****Exception*****was happnd "+sw.toString());
        mv.addObject("title", "Ошибка");
        return mv;
    }

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ModelAndView handlerScheduleNotFoundException() {

        ModelAndView mv = new ModelAndView("404");

        return mv;
    }


    @ExceptionHandler(StationNotFoundException.class)
    public ModelAndView handlerStationNotFoundException() {

        ModelAndView mv = new ModelAndView("404");

        return mv;
    }


}

