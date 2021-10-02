package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC2 {
    @RequestMapping("/getYoilMVC2") // http://localhost/ch2/getYoilMVC2
    public String main(
    		@RequestParam(defaultValue="-1") int year, 
    		@RequestParam(defaultValue="-1") int month, 
    		@RequestParam(defaultValue="-1") int day, 
    		Model model
    ) throws IOException {

    	if(!isValid(year, month, day)) 
    		return "yoilError";
    	
        // 2. 작업
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        
        return "yoil";
    } // main
    
    public boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
} // class
