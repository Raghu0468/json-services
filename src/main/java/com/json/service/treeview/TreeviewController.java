package com.json.service.treeview;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;

@Controller
@RequestMapping("/")
public class TreeviewController {

   @RequestMapping(value = "treeview", produces = "application/json")
   public @ResponseBody
   Object[] getTreeviewList() {

      try {
         JSONParser parser = new JSONParser();
         JSONArray a = (JSONArray) parser.parse(new FileReader("D:\\Project\\SpringAngularjs\\src\\main\\resources\\json\\treeview.json"));

         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

}
