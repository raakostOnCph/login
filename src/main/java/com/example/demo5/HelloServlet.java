package com.example.demo5;

import com.example.demo5.Entitet.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet
{
    private String message;

    public void init()
    {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("ida", "666"));
        personList.add(new Person("lone", "1234"));
        personList.add(new Person("Lonny", "313"));
        personList.add(new Person("Feehaar", "4545"));

        Map<String, Person> personMap = new HashMap<>();

        for (Person person : personList) {

            personMap.put(person.getNavn(), person);
        }

        getServletContext().setAttribute("kunde", personMap);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
//        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        System.out.println("det var hvad jeg fik " + navn + " " + kode);


        //request.getRequestDispatcher("WEB-INF/hemmelig.jsp").forward(request,response);

    }

    public void destroy()
    {
    }
}