/*
 * Copyright (C) 2017 AMIS research group, Faculty of Mathematics and Physics, Charles University in Prague, Czech Republic
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package states;

import com.mycompany.mcbotproject.EmptyBot;
import cz.cuni.amis.pogamut.base3d.worldview.object.Location;
import cz.cuni.amis.pogamut.ut2004.communication.messages.ItemType;
import cz.cuni.amis.pogamut.ut2004.communication.messages.gbinfomessages.NavPoint;
import cz.cuni.amis.pogamut.ut2004.communication.messages.gbinfomessages.Player;

/**
 *
 * @author m3lefloc
 */
public class Hurt  extends State{


    public Hurt(EmptyBot bot) {
        super(bot);
    }

    public void run() {
        _bot.getShoot().stopShooting();
        if (_bot.getItems().getNearestSpawnedItem(ItemType.Category.HEALTH) != null) {
            _bot.getNavigation().navigate(_bot.getItems().getPathNearestSpawnedItem((ItemType.Category.HEALTH)));
        } else if (_bot.getPlayers().canSeeEnemies()) {
            NavPoint nav = _bot.getNavPoints().getRandomNavPoint();
            _bot.getNavigation().navigate(nav);
            if ((((int) Math.random()) % 100) < 10) {
                switch (((int) Math.random()) % 2) {
                    case 0:
                        _bot.getMove().strafeTo(nav, nav);
                        break;
                    case 1:
                        _bot.getMove().doubleJump();
                        break;
                }
            }
        }
    }
}
