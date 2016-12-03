package hyeonyoung.dicegame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hyeonyoung.dicegame.service.ConfigureService;
import hyeonyoung.dicegame.vo.Panel;


@Controller
public class ConfigureController {
	
	@Autowired
	ConfigureService configureService;

	@Autowired
	Panel panel;
	@RequestMapping(value = "/initconfigure", method = RequestMethod.POST)
	public String initConfigure(HttpServletRequest request, Model model) throws Exception {
		
		configureService.initGame();
		model.addAttribute("afterCells", panel.getCell());	

		return "configure";
	}
	
	@RequestMapping(value = "/configurehome", method = RequestMethod.GET)
	public String configureHome(HttpServletRequest request, Model model) {
		model.addAttribute("afterCells", panel.getCell());
		return "configure";
	}
	@RequestMapping(value = "/setconfigure", method = RequestMethod.POST)
	public String setConfigure(HttpServletRequest request, Model model) {
		String before = request.getParameter("beforeCell");
		String after = request.getParameter("afterCell");

		int beforeCell = Integer.parseInt(before);
		int afterCell = Integer.parseInt(after);

		configureService.setConfigure(beforeCell, afterCell);
		model.addAttribute("afterCells", panel.getCell());

		return "configure";
	}
	
}
