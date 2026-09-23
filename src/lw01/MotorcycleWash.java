public class MotorcycleWash extends washService {
    private static final int per_day = 15000;
    private static final int SETUP_FEE = 5000;
    public MotorcycleWash(String id , int days){
        super(id, days);
    }
@Override
    public int calculateCharge() {
        return getDays() * per_day + SETUP_FEE;
    }
    public String label() {
        return "MotorCycle";
    }
}
