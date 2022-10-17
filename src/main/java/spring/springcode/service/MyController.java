 package spring.springcode.service;

 
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
 public class MyController
 {
 	@Autowired
 	EmployeSerivce service;
 	@RequestMapping("/")
 	public String showHomePage(Model model)
 	{
 		
 		System.out.println("Display is called");
 		List<Employe> list= service.displayData();
 		for(Employe employe : list)
 		{
 			System.out.println(employe.getId()+ " "+employe.getName());
 		}
 		model.addAttribute("abc", list);
 		return "show";
 	}
 	@RequestMapping("/addData")
 	public String newData(Model model)
 	{
 		Employe employe= new Employe();
 		model.addAttribute("emp", employe);
 		return "add_emp";
 	}
 	@RequestMapping(value =  "/save" , method = RequestMethod.POST)
 	public String saveData(@ModelAttribute("emp") Employe employe)
 	{
 		service.saveProduct(employe);
 		return "redirect:/";
 	}
 	@RequestMapping("/edit/{id}")
 	public ModelAndView editData(@PathVariable(name = "id") int id)
 	{
 		ModelAndView view = new ModelAndView("edit_data");
 		Employe employe = service.getProd(id);
 		view.addObject("emp", employe);
 		return view;
 	}
 	
 	@RequestMapping("/delete/{id}")
 	public String deleteData(@PathVariable(name = "id") int id)
 	{
 		service.delete(id);
 		return "redirect:/";
 	}
 }







