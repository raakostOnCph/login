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
        personList.add(new Person("Feehaar", "4545", "admin"));

        Map<String, Person> personMap = new HashMap<>();

        for (Person person : personList) {

            personMap.put(person.getNavn(), person);
        }

        getServletContext().setAttribute("kunder", personMap);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        Map<String , Person> personMap = (Map<String, Person>) getServletContext().getAttribute("kunder");

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        System.out.println(navn + " " + kode);



        if (request.getSession(false) == null || !request.isRequestedSessionIdValid() ) {

            System.out.println("vi kender allerede brugeren");
            request.getRequestDispatcher("WEB-INF/hemmelig.jsp").forward(request,response);

        }


        // findes bruger
     if (!personMap.containsKey(navn)) {

         request.setAttribute("besked", "en bruger med det navn fandtes ikke !");

         request.getRequestDispatcher("index.jsp").forward(request,response);

    }
   // bruger kode er ikke rigtig
     if (!personMap.get(navn).getKode().equalsIgnoreCase(kode)) {

         request.setAttribute("besked", "Koden er forkert, prøv igen");

         request.getRequestDispatcher("index.jsp").forward(request,response);


     }


     HttpSession session = request.getSession();




     session.setAttribute("bruger",  personMap.get(navn));
     request.setAttribute("id", session.getId());

     session.setAttribute("navn", navn);
     session.setAttribute("brugerKode", kode);

     request.getRequestDispatcher("WEB-INF/hemmelig.jsp").forward(request,response);

        //request.getRequestDispatcher("WEB-INF/hemmelig.jsp").forward(request,response);

    }

    public void destroy()
    {
    }
}