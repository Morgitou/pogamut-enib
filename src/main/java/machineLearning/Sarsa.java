package machineLearning;

import com.mycompany.mcbotproject.EmptyBot;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author m3lefloc
 */
public class Sarsa {

    private EmptyBot _agent;

    float alpha;
    float lambda;
    float epsilon;

    private ArrayList<MemoryPattern> _memory;
    private Perception _S;
    private Perception _SP;
    private String _AP;
    
    private ArrayList<String> _possibleActions;
    String actions[] = {"jump", "dodge_left"};
   
    
    // String actions[] = {"hide", "heal", "dodge", "shoot", "move", "refill", "switch_weapon", "nothing"};
    
    public Sarsa(EmptyBot agent) {
        _agent = agent;
        _memory = new ArrayList();
                      
    }

    public void init() {
        _S = new Perception(_agent);
        _S.updatePerception();
    }
    
  

    public void algorithm() {

    }

}
