package com.json.service.treeview;

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
public class TreeviewController {

	   @RequestMapping(value = "treeview", produces = "application/json")
	   public @ResponseBody
	   Object[] getTreeviewList() {

		   try {
			     ClassPathResource classPathResource = new ClassPathResource("json" + "\\treeview.json");
			     JSONParser parser = new JSONParser();
			     JSONArray a = (JSONArray) parser.parse(new FileReader(classPathResource.getFile()));
	         return a.toArray();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return null;
	   }

	}
