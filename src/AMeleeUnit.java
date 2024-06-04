import java.awt.*;

public abstract class AMeleeUnit extends AArmy {
    public AMeleeUnit(String name, Color color) {
        super(name, color);
    }

    @Override
    public abstract void acceptAttack(IAttack attack);
}





// Analogicznie implementacje dla pozostałych jednostek: General, Infantry, Cavalry, Artillery
