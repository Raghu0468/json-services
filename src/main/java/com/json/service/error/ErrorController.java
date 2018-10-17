package com.json.service.error;

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
public class ErrorController {

   @RequestMapping(value = "error404", produces = "application/json")
   public @ResponseBody
   Object[] getErrorList() {

	   try {
		     ClassPathResource classPathResource = new ClassPathResource("json" + "\\error404.json");
		     JSONParser parser = new JSONParser();
		     JSONArray a = (JSONArray) parser.parse(new FileReader(classPathResource.getFile()));
         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

}
