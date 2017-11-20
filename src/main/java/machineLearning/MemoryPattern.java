package machineLearning;

public class MemoryPattern {

    private Perception _perception;
    private String _action;
    private float _quality;

    public MemoryPattern(Perception state, float quality, String action) {

        _perception = state.copy();
        _quality = quality;
        _action = action;
    }

    public Perception getPerception() {
        return _perception;
    }

    public float getQuality() {
        return _quality;
    }

    public String getAction() {
        return _action;
    }

    public void setQuality(float q) {
        _quality = q;
    }

}
