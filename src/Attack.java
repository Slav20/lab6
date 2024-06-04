import java.util.HashMap;
import java.util.Map;

public class Attack implements IAttack {
    private Map<AttackTypes, Double> attacks = new HashMap<>();

    @Override
    public double getDamage(AttackTypes type) {
        return attacks.getOrDefault(type, 0.0);
    }

    @Override
    public void setDamage(AttackTypes type, double value) {
        attacks.put(type, value);
    }
}