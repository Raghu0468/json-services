package com.json.service.calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CalendarController {


   @RequestMapping(value = "calendar", produces = "application/json")
   public @ResponseBody
   Object[] getCalendarList(HttpServletRequest request) {

      try {
         ClassPathResource classPathResource = new ClassPathResource("json" + "\\calendar.json");
         JSONParser parser = new JSONParser();
         JSONArray a = (JSONArray) parser.parse(new FileReader(classPathResource.getFile()));

         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   static List<JSONObject> listEvents = new ArrayList<>();


   @RequestMapping(value = "listevents", produces = "application/json")
   public @ResponseBody
   Object[] getEvents(HttpServletRequest request) {

      try {

         JSONObject event1 = new JSONObject();
         event1.put("title", "All Day Event");
         event1.put("start", "new Date(y, m, 1)");
         event1.put("className", "label-important");

         listEvents.add(event1);

         JSONObject event2 = new JSONObject();
         event2.put("title", "King Event");
         event2.put("start", "new Date(y, m, 2)");
         event2.put("className", "label-important");

         listEvents.add(event2);

         JSONObject event3 = new JSONObject();
         event3.put("title", "Some Event");
         event3.put("start", "new Date(y, m, 3)");
         event3.put("className", "label-info");

         listEvents.add(event3);

      } catch (Exception e) {
         e.printStackTrace();
      }

      return listEvents.toArray();

   }

   @RequestMapping(value = "addevent", produces = "application/json")
   public @ResponseBody
   Object[] getForm(HttpServletRequest request) {

      try {

         String title = request.getParameter("title");

         JSONObject event1 = new JSONObject();
         event1.put("title", title);
         event1.put("start", "new Date(y, m, 4)");
         event1.put("className", "label-info");

         listEvents.add(event1);

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

}
