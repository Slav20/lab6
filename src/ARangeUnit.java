import java.awt.*;
public abstract class ARangeUnit extends AArmy {
    public ARangeUnit(String name, Color color) {
        super(name, color);
    }

    @Override
    public abstract void acceptAttack(IAttack attack);
}

