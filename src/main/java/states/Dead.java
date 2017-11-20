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

/**
 *
 * @author m3lefloc
 */
public class Dead  extends State{
    
    public Dead(EmptyBot bot) {
        super(bot);
    }
    
    public void run() {
        _bot.getBody().getCommunication().sendGlobalTextMessage("I'm dead; really dead.");
    }
}
