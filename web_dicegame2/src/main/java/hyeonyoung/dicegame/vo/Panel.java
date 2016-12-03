package hyeonyoung.dicegame.vo;

import org.springframework.stereotype.Component;

@Component
public class Panel {
	private int cell[];
	
	public Panel() {
		cell = new int[30];
		for(int i=0;i<30;i++) {
			cell[i]=i;
		}
	}
	
	public int[] getCell() {
		return cell;
	}
	
	public void setCell(int[] cell) {
		this.cell = cell;
	}
}
