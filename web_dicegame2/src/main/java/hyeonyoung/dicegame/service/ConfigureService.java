package hyeonyoung.dicegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyeonyoung.dicegame.vo.Panel;
import hyeonyoung.dicegame.vo.Status;

@Service
public class ConfigureService {
	@Autowired
	Panel panel;
	
	@Autowired
	Status status;
	
	//final private int Goal = 29;
	
	public void initGame() {
		int initcell[] = panel.getCell();

		for (int i = 0; i < initcell.length; i++)
			initcell[i] = i;
	}
	
	public void setConfigure(int beforeCell, int afterCell) {
		int initcell[] = panel.getCell();
		initcell[beforeCell] = afterCell;
		panel.setCell(initcell);
		status.setCell(panel.getCell());
	}
	/*
	private void make_trap_cells() {
		cell[10]=0;
		cell[28]=0;
		cell[8]=3;
		cell[15]=5;
		cell[21]=12;
		cell[25]=17;
	}
	
	private void make_bonus_cells() {
		cell[11]=20;
		cell[26]=27;
		cell[9]=14;
		cell[16]=22;
	}
	*/
}
