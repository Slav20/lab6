public interface IMovement {
    void moveTo(int x, int y);
    double speed(ArmyProperties property, String unitType);
    void reportPosition(int x, int y);
}