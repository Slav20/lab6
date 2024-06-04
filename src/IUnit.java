public interface IUnit {
    double getProperty(ArmyProperties property);
    IAttack getAttack();
    void acceptAttack(IAttack attack);
}



