package com.ccyblog.test;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/1.
 */
public class SessionServlet extends HttpServlet {
    int accessCount = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public SessionServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        String username = null;
        int count = 0;
        for (Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals("fuckyou")){
                count = Integer.parseInt(cookie.getValue());
                break;
            }
        }
        count = count + 1;
        Cookie fuckyou = new Cookie("fuckyou", "" + count);
        fuckyou.setMaxAge(100000000);
        resp.addCookie(fuckyou);

        writer.println("cookie = " + count);


    }
}
