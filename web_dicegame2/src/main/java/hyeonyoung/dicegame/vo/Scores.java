package hyeonyoung.dicegame.vo;

import org.springframework.stereotype.Component;

@Component
public class Scores {
	private String name;
	private int win;
	private int lose;
	private int draw;

	public String getName() {
		return name;
	}

	public Scores setName(String name) {
		this.name = name;
		return this;
	}

	public int getWin() {
		return win;
	}

	public Scores setWin(int win) {
		this.win = win;
		return this;
	}

	public int getLose() {
		return lose;
	}

	public Scores setLose(int lose) {

		this.lose = lose;
		return this;
	}

	public int getDraw() {
		return draw;
	}

	public Scores setDraw(int draw) {
		this.draw = draw;
		return this;
	}

}
