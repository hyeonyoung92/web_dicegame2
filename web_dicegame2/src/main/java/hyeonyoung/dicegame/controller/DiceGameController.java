package hyeonyoung.dicegame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hyeonyoung.dicegame.enumclass.WinningStatus;
import hyeonyoung.dicegame.service.ConfigureService;
import hyeonyoung.dicegame.service.DiceService;
import hyeonyoung.dicegame.service.ScoreService;
import hyeonyoung.dicegame.vo.Scores;
import hyeonyoung.dicegame.vo.Status;

@Controller
public class DiceGameController {

	private String username;
	private Scores score;

	@Autowired
	DiceService diceService;

	@Autowired
	ScoreService scoreService;
	
	@Autowired
	ConfigureService configureService;

	@Autowired
	Status status;

	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public String startGame(HttpServletRequest request, Model model) throws Exception {

		username = (String) request.getParameter("username");

		score = scoreService.initScore(username);
		diceService.initGame();
		
		model.addAttribute("username", username);
		model.addAttribute("userValue", status.getUserValue());
		model.addAttribute("alphaValue", status.getAlphaValue());
		model.addAttribute("curCellForUser", status.getCurCellForUser());
		model.addAttribute("curCellForAlphaDice", status.getCurCellForAlphaDice());
		
		return "playgame";
	}

	@RequestMapping(value = "/roll", method = RequestMethod.POST)
	public String playGame(HttpServletRequest request, Model model) throws Exception {

		WinningStatus isGameFinished = diceService.rollingDice();
		
		String message;
		
		switch (isGameFinished) {
		case Player:
		scoreService.updateScore(score.setWin(score.getWin() + 1));
			message = username + " ¥‘¿Ã ¿Ã∞ÂΩ¿¥œ¥Ÿ.";
			model.addAttribute("message", message);
			model.addAttribute("username", username);
			model.addAttribute("curCellForUser", status.getCurCellForUser());
			model.addAttribute("curCellForAlphaDice", status.getCurCellForAlphaDice());
			return "result";

		case AlphaDice:
		scoreService.updateScore(score.setLose(score.getLose() + 1));
			message = "AlphaDice ¥‘¿Ã ¿Ã∞ÂΩ¿¥œ¥Ÿ.";
			model.addAttribute("username", username);
			model.addAttribute("message", message);
			model.addAttribute("curCellForUser", status.getCurCellForUser());
			model.addAttribute("curCellForAlphaDice", status.getCurCellForAlphaDice());
			return "result";

		case Draw:
			scoreService.updateScore(score.setDraw(score.getDraw() + 1));
			message = "Draw";
			model.addAttribute("username", username);
			model.addAttribute("message", message);
			model.addAttribute("curCellForUser", status.getCurCellForUser());
			model.addAttribute("curCellForAlphaDice", status.getCurCellForAlphaDice());
			return "result";

		case NotYet:
			model.addAttribute("username", username);
			model.addAttribute("userValue", status.getUserValue());
			model.addAttribute("alphaValue", status.getAlphaValue());
			model.addAttribute("curCellForUser", status.getCurCellForUser());
			model.addAttribute("curCellForAlphaDice", status.getCurCellForAlphaDice());
			return "playgame";

		default:
			return "playgame";

		}
	
	}

}
