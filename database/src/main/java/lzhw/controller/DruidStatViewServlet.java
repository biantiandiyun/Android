package lzhw.controller;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/druid/*")
public class DruidStatViewServlet extends StatViewServlet {

}
