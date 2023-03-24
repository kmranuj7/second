package com.attendance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attendance.entities.Employee;
import com.attendance.repository.EmployeeRepository;
import com.attendance.service.RegisterService;




@Controller
public class HomeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Autowired
    private RegisterService registerService;

	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","Home -Attendance System");
		return "home";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Signup -Attendance System");
		model.addAttribute("employee",new Employee());
		return "signup";
	}
	
	@RequestMapping(value="/do_register", method=RequestMethod.POST)
	public String registerEmployee(@ModelAttribute("employee") Employee employee,Model model)
	{
	
		System.out.println(employee);
		Employee result=this.employeeRepository.save(employee);
		model.addAttribute("employee",result);
		
		return "signup";
	}
	//PdfCreaterCONTROLLER
	 @PostMapping("/do_invoice")
	    public ResponseEntity<byte[]> registerationEmployee(@ModelAttribute("employee") Employee employee) {
	        byte[] pdfBytes = registerService.generateRegistrationPdf(employee);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        headers.setContentDispositionFormData("attachment", "registration.pdf");
	        headers.setContentLength(pdfBytes.length);
	        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	    }
	    
	    
	   
	
	
	
	@GetMapping("/login")
	public String login(Model model)
	{
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		model.addAttribute("title","Login -Attendance System");
		return "login";
	}

	@PostMapping("/employee_login")
	public String employeeLogin(@ModelAttribute("employee") Employee employee)
	{
		System.out.println(employee.getEmail());
		System.out.println(employee.getPassword());
		
		
		return "employeeDashboard";
	}


}
