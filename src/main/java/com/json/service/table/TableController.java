package com.json.service.table;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;

@Controller
@CrossOrigin
@RequestMapping("/")
public class TableController {

   @RequestMapping(value = "simpledynamic", produces = "application/json")
   public @ResponseBody
   Object[] getTableList() {

	   try {
		     ClassPathResource classPathResource = new ClassPathResource("json" + "\\simpledynamic.json");
		     JSONParser parser = new JSONParser();
		     JSONArray a = (JSONArray) parser.parse(new FileReader(classPathResource.getFile()));
         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

}
