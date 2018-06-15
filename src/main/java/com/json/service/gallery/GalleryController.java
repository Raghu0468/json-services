package com.json.service.gallery;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;

@Controller
@RequestMapping("/")
public class GalleryController {

   @RequestMapping(value = "gallery", produces = "application/json")
   public @ResponseBody
   Object[] getGalleryList() {

      try {
    	  ClassPathResource classPathResource = new ClassPathResource("json" + "\\gallery.json");
         JSONParser parser = new JSONParser();
         JSONArray a = (JSONArray) parser.parse(new FileReader(classPathResource.getFile()));

         return a.toArray();

      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

}
