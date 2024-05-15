package com.bma.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspUtil {
    private static final String JSP_PATH = "jsp/%s.jsp";

    public String getPath(String jspName){
        return new String(JSP_PATH.formatted(jspName));
    }
}
