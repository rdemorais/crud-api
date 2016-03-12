package br.com.crudapi.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/crud")
public class DefaultCrudController {
	
	private static final Logger logger = Logger.getLogger(DefaultCrudController.class);
	
	
	@RequestMapping(value="/list/{idCrud}/{offset}/{max}", method=RequestMethod.GET)
	public String listPage(@PathVariable String idCrud, @PathVariable Integer offset, @PathVariable Integer max, Model model) {
		return "crud/list";
	}
	
	@RequestMapping(value="/new/{idCrud}", method=RequestMethod.GET)
	public String blankForm(@PathVariable String idCrud, Model model) {
		return "crud/new";
	}
	
	@RequestMapping(value="/create/{idCrud}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	@ResponseBody
	public CrudResponse create(@PathVariable String idCrud, @RequestBody String jsonForm) {
		return CrudResponse.ok();
	}
	
	@RequestMapping(value="/update/{idCrud}/{pk}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	@ResponseBody
	public CrudResponse update(@PathVariable String idCrud, @PathVariable Long pk, @RequestBody String jsonForm) {
		return CrudResponse.ok();
	}
	
	@RequestMapping(value="/delete/{idCrud}/{pk}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String idCrud, @PathVariable Long pk) {
		return new ModelAndView("redirect:/crud/list/"+idCrud+"/0/0");
	}
	
	@RequestMapping(value="/load/{idCrud}/{pk}", method=RequestMethod.GET)
	public String load(@PathVariable String idCrud, @PathVariable Long pk, Model model) {
		return "crud/new";
	}
}