package hyeonyoung.dicegame.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import hyeonyoung.dicegame.dao.ScoreDAO;
import hyeonyoung.dicegame.vo.Scores;

public class ScoreService {

	@Autowired
	Scores scores;

	@Autowired
	ScoreDAO scoreDAO;

	public Scores initScore(String username) throws Exception {
		Scores score = scoreDAO.selectOne(username);
		if (score == null) {
			score = new Scores().setName(username).setWin(0).setLose(0).setDraw(0);
			scoreDAO.insertScore(score);
		}
		return score;
	}

	public List<Scores> scoreView() throws Exception {

		List<Scores> scores = scoreDAO.selectAllScores();

		return scores;
	}

	public void updateScore(Scores score) throws Exception {
		scoreDAO.update(score);
	}
	
}
