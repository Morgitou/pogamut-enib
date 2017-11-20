package machineLearning;

import com.mycompany.mcbotproject.EmptyBot;

/**
 *
 * @author m3lefloc
 */
public class Perception {

    private EmptyBot _agent;

    //-- Sensors
    private int _health;
    private boolean _enemyVisible;
    private double _distanceToEnnemy;
    private String _ennemyWeapon;
    //------------------------+

    public Perception(EmptyBot agent) {

        _agent = agent;

        _health = _agent.getInfo().getHealth();
        _enemyVisible = _agent.getPlayers().canSeeEnemies();
        if (_enemyVisible) {
            _distanceToEnnemy = _agent.getBot().getLocation().getDistance(_agent.getPlayers().getNearestVisibleEnemy().getLocation());
            _agent.getPlayers().getNearestVisibleEnemy().getWeapon();
        }
    }

    public Perception copy() {

        Perception p = new Perception(this.getAgent());

        p.setEnemyVisible(this.isEnemyVisible());
        p.setHealth(this.getHealth());
        p.setDistanceToEnnemy(this.getDistanceToEnnemy());
        p.setEnnemyWeapon(this.getEnnemyWeapon());

        return p;
    }

    public void updatePerception() {

        this.setDistanceToEnnemy(this.getAgent().getBot().getLocation().getDistance(this.getAgent().getPlayers().getNearestVisibleEnemy().getLocation()));
        this.setEnnemyWeapon(this.getAgent().getPlayers().getNearestVisibleEnemy().getWeapon());
        this.setEnemyVisible(this.getAgent().getPlayers().canSeeEnemies());
        this.setHealth(this.getAgent().getInfo().getHealth());
    }

    public boolean equals(Perception s) {
        boolean b = this.getAgent() == s.getAgent()
                && this.getHealth() == s.getHealth()
                && this.getDistanceToEnnemy() == s.getDistanceToEnnemy()
                && this.getEnnemyWeapon() == s.getEnnemyWeapon()
                && this.isEnemyVisible() == s.isEnemyVisible();
        return b;
    }

    public double getDistanceToEnnemy() {
        return _distanceToEnnemy;
    }

    public void setDistanceToEnnemy(double _distanceToEnnemy) {
        this._distanceToEnnemy = _distanceToEnnemy;
    }

    public String getEnnemyWeapon() {
        return _ennemyWeapon;
    }

    public void setEnnemyWeapon(String _ennemyWeapon) {
        this._ennemyWeapon = _ennemyWeapon;
    }
    
    public EmptyBot getAgent() {
        return _agent;
    }

    public void setAgent(EmptyBot _agent) {
        this._agent = _agent;
    }

    public int getHealth() {
        return _health;
    }

    public void setHealth(int _health) {
        this._health = _health;
    }

    public boolean isEnemyVisible() {
        return _enemyVisible;
    }

    public void setEnemyVisible(boolean _enemyVisible) {
        this._enemyVisible = _enemyVisible;
    }

}
