package egovframework.lab.ajax.web;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.lab.ajax.service.EmployeeService;

@Controller
public class AjaxController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	@RequestMapping(value = "/autoCompleteSimple.do")	
	public ModelAndView simplAjax(@RequestParam("keyword") String keyword) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		String searchName = URLDecoder.decode(keyword, "utf-8");
		
		LOGGER.debug("▶▶▶▶ SEARCHNAME > " + searchName);
		
		List<String> nameList = employeeService.getNameListForSuggest(searchName);
		LOGGER.debug("▶▶▶▶ nameList > " + nameList.size());
		
		if (nameList.size() > 0) {
			for (String name : nameList) {
				LOGGER.debug("NAME : " + name);
			}
		}
		modelAndView.addObject("resultList", nameList);
		
		return modelAndView;
	}
}
