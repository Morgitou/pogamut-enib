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
import cz.cuni.amis.pogamut.ut2004.agent.module.sensomotoric.Weapon;
import cz.cuni.amis.pogamut.ut2004.communication.messages.ItemType;
import cz.cuni.amis.pogamut.ut2004.communication.messages.gbinfomessages.Player;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author m3lefloc
 */
public class Attack extends State{

    private Location _lastPlayerLocation;
    private Player _target;
    
    public Attack(EmptyBot bot) {
        super(bot);
    }
    
    public void setTarget(Player target){
        _target = target;
    }

    public Player getTarget() {
        return _target;
    }
    

    public void run() {
        _lastPlayerLocation = this.getTarget().getLocation();
        if (!_bot.getWeaponry().hasAmmoForWeapon(_bot.getWeaponry().getCurrentWeapon().getType())) {
            _bot.getBody().getCommunication().sendGlobalTextMessage("No Ammo!");
           
                _bot.getBody().getCommunication().sendGlobalTextMessage("I have Loaded Weapon, switching!");
                boolean next = false;
                if (getWeaponWithAmmos() != null){
                    _bot.getWeaponry().changeWeapon(getWeaponWithAmmos());
                    next = true;
                }
                
                if (!next &&_bot.getItems().getAllItems(ItemType.Category.AMMO).size() != 0) {
                _bot.getBody().getCommunication().sendGlobalTextMessage("No Ammo! Im going for it");
                _bot.getNavigation().navigate(_bot.getItems().getPathNearestSpawnedItem(ItemType.Category.AMMO));
            }
        }
       
        _bot.getShoot().shoot(this.getTarget());
        Location locationBot = _bot.getBot().getLocation();
        Location locationTarget = this.getTarget().getLocation();
        if (Location.getDistance(locationBot, locationTarget) > 300.0) {
            _bot.getNavigation().navigate(this.getTarget());
        } else {
            _bot.getNavigation().stopNavigation();
        }
    }

    public Location getLastPlayerLocation() {
        return _lastPlayerLocation;
    }
    
    public Weapon getWeaponWithAmmos() {
        Map<ItemType,Weapon> weapons = _bot.getWeaponry().getWeapons();
        Iterator<Map.Entry<ItemType, Weapon>> it = weapons.entrySet().iterator();
        while (it.hasNext()) {
            Weapon weapon = it.next().getValue();
            if (weapon.getAmmo() > 0) {
                return weapon;
            }
        } 
        return null;
    }
}
