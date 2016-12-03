package hyeonyoung.dicegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyeonyoung.dicegame.enumclass.WinningStatus;
import hyeonyoung.dicegame.vo.Panel;
import hyeonyoung.dicegame.vo.Status;

@Service
public class DiceService {

	@Autowired
	Status status;
	@Autowired
	Panel panel;
	final private int Goal = 29;

	public void initGame() {
		status.setAlphaValue(0);
		status.setCell(new int[30]);
		status.setCurCellForAlphaDice(0);
		status.setCurCellForUser(0);
		status.setUserValue(0);

	}

	public WinningStatus rollingDice() {

		int userValue = status.getUserDice().roll();
		int alphaValue = status.getAlphaDice().roll();

		int curCellForUser = status.getCurCellForUser() + userValue;
		int curCellForAlphaDice = status.getCurCellForAlphaDice() + alphaValue;

		status.setUserValue(userValue);
		status.setAlphaValue(alphaValue);

		status.setCurCellForUser(curCellForUser);
		status.setCurCellForAlphaDice(curCellForAlphaDice);

		if (curCellForUser > Goal && curCellForAlphaDice > Goal)
			return WinningStatus.Draw;
		else if (curCellForUser > Goal && curCellForAlphaDice <= Goal)
			return WinningStatus.Player;
		else if (curCellForUser <= Goal && curCellForAlphaDice > Goal)
			return WinningStatus.AlphaDice;

		else {
			if (curCellForUser != panel.getCell()[curCellForUser]) {
				status.setCurCellForUser(panel.getCell()[curCellForUser]);
			}
			if (curCellForAlphaDice != panel.getCell()[curCellForAlphaDice]) {
				status.setCurCellForAlphaDice(panel.getCell()[curCellForAlphaDice]);
			}

			return WinningStatus.NotYet;
		}
	}
}
