package com.json.service.calendar;

import com.mvc.AppConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
@CrossOrigin
@RequestMapping("/")
public class CalendarController {

   @Autowired
   ResourceLoader resourceLoader;


   @Autowired
   AppConfig config;


   @RequestMapping(value = "calendar", produces = "application/json")
   public @ResponseBody
   Object[] getCalendarList(HttpServletRequest request) {

      try {
         JSONParser parser = new JSONParser();
         /*
               If you want to read file from resources json folder use the following code
          */
         Resource resource = resourceLoader.getResource("classpath:json/calendar.json");
         Scanner s = new Scanner(resource.getInputStream()).useDelimiter("D:\\Project\\json services\\src\\main\\resources\\json\\calendar.json");

         /*
            If you want to use absolute path for the JSON files, use the below code
          */
         File file = new File(config.getPath());
         Scanner scan = new Scanner(file);
         scan.useDelimiter("\\Z");

         // For Resource Path
         JSONArray a = (JSONArray) parser.parse(s.next());
         // For Absolute path
         //         JSONArray a = (JSONArray) parser.parse(scan.next());

         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   static List<JSONObject> listEvents = new ArrayList<JSONObject>();


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
