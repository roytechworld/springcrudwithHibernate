package com.ptech.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ptech.dao.StudentDao;
import com.ptech.pojo.StudentMaster;
import com.ptech.service.MyServiceDao;


/**
 * Handles requests for the application home page.
 */
/**
 * Software : PR Stock software
 * Developer : Pradipto Roy (Java developer)
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private MyServiceDao loadservice;
	
	@Autowired
	private StudentDao student;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
	    List<StudentMaster> studentlist=loadservice.getStudentDetails();
		  
		int paginationval=loadservice.getStudentDetails().size()/5;
		  
	    List<Integer> paginationcounter=new ArrayList<Integer>();
		for(int i=0;i<paginationval;i++)
		{
			paginationcounter.add(i);
		}
		   
		 model.addAttribute("paginationlist", paginationcounter); 
		    model.addAttribute("stlist", studentlist);
		
		return "home";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST,params={"name","address"})
	public String save(Model model,HttpServletRequest request,@RequestParam("name") String name,@RequestParam("address")
	String address)
	{
	
    System.out.println("name found "+name);	
    System.out.println("address found "+address);
	
    StudentMaster obj=new StudentMaster("", name, address);
    
    boolean save=loadservice.saveDetails(obj);
    if(save)
    {
    	logger.info("Save successfully");
    	
    }
    
    List<StudentMaster> studentlist=loadservice.getStudentDetails();
    
    model.addAttribute("stlist", studentlist);
	
	return "savePage";
		
	}
	
	
    @RequestMapping(value="/viewemp/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
//        List<Emp> list=dao.getEmployeesByPage(pageid,total);  
        
        List<StudentMaster> studentlist=student.getAllDetails(pageid, total);
        
    	int paginationval=loadservice.getStudentDetails().size()/5;
		  
	    List<Integer> paginationcounter=new ArrayList<Integer>();
		for(int i=0;i<paginationval;i++)
		{
			paginationcounter.add(i);
		}
          
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("paginationlist", paginationcounter); 
		mav.addObject("stlist",studentlist);	
		
		
		
        return mav;
    }  
	
}
