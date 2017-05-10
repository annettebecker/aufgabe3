package com.mycompany.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.CurrentWeather;

@WebServlet(value="/weather", name="weatherServlet")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        
        OpenWeatherMap owa = new OpenWeatherMap("61cbc8eeb7a3f9b15cb8b583b4ea5cda");
        CurrentWeather cwd = owa.currentWeatherByCityName("Bochum");
                      
        resp.getWriter().print("{\"Temperatur\": \""+cwd.getMainInstance().getTemperature()+"\","
                + "\"Luftfeuchtigkeit\": \""+cwd.getMainInstance().getHumidity()+"\" }");
    }

}
