package hyeonyoung.dicegame.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Status {

	@Autowired
	@Qualifier("userDice")
	private Dice userDice;
	@Autowired
	@Qualifier("alphaDice")
	private Dice alphaDice;

	private int userValue;
	private int alphaValue;
	private int[] cell;

	public int[] getCell() {
		return cell;
	}

	public void setCell(int[] cell) {
		this.cell = cell;
	}

	private int curCellForUser;
	private int curCellForAlphaDice;

	public Dice getUserDice() {
		return userDice;
	}

	public void setUserDice(Dice userDice) {
		this.userDice = userDice;
	}

	public Dice getAlphaDice() {
		return alphaDice;
	}

	public void setAlphaDice(Dice alphaDice) {
		this.alphaDice = alphaDice;
	}

	public int getUserValue() {
		return userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	public int getAlphaValue() {
		return alphaValue;
	}

	public void setAlphaValue(int alphaValue) {
		this.alphaValue = alphaValue;
	}

	public int getCurCellForUser() {
		return curCellForUser;
	}

	public void setCurCellForUser(int curCellForUser) {
		this.curCellForUser = curCellForUser;
	}

	public int getCurCellForAlphaDice() {
		return curCellForAlphaDice;
	}

	public void setCurCellForAlphaDice(int curCellForAlphaDice) {
		this.curCellForAlphaDice = curCellForAlphaDice;
	}

}
