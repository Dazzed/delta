package com.delta.cru.svc;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("error")
public class AppErrorSvc implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH, method = { RequestMethod.GET })
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
