import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AArmy implements IUnit {
    protected Map<ArmyProperties, Double> stats = new HashMap<>();
    protected String name;
    protected Color color;
    protected IAttack attack;
    protected IMovement movement;

    public AArmy(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    @Override
    public double getProperty(ArmyProperties property) {
        return stats.getOrDefault(property, 0.0);
    }

    @Override
    public IAttack getAttack() {
        return attack;
    }

    @Override
    public abstract void acceptAttack(IAttack attack);
}





