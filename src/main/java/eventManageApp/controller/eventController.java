package eventManageApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import eventManageApp.form.EventEntryForm;
import eventManageApp.service.EventListService;

@Controller
public class eventController {
	@Autowired
	EventListService eventListService;
	
	@GetMapping("/")
	public String index() {
		return "eventlist";
	}
	
	@PostMapping("/eventlist")
	public String addEvent(EventEntryForm eventEntryForm) {
		return "/eventdetail";
	}
}
