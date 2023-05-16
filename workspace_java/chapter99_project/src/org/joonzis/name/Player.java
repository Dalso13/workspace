package org.joonzis.name;

import org.joonzis.Filed.Fight;
import org.joonzis.Filed.FiledStart;
import org.joonzis.Filed.Quest;
import org.joonzis.city.Select_city;
import org.joonzis.city.Start;
import org.joonzis.status.Monster;
import org.joonzis.status.PlayerStatus;
import org.joonzis.status.Slime;

public interface Player {
	PlayerStatus player = new PlayerStatus();
	title title = new title();
	Start start = new Start();
	Select_city secy = new Select_city();
	StatusWindow stat = new StatusWindow();
	FiledStart filedStart = new FiledStart();
	Fight fight = new Fight();
	Quest quest = new Quest();
	Save save = new Save();
	Slime monster1 = new Slime();
	Monster monster = new Monster(); 
	
}