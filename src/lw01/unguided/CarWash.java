public class CarWash extends washService {

    private static final int first_three_day = 35000;
    private static final int next_day = 25000;
    private static final int SETUP_FEE = 15000;

    public CarWash(String id, int days){
        super(id, days);
    }
    @Override
    public int calculateCharge() {
        int days = getDays();
        int firstthree = Math.min(days, first_three_day);
        int nextday = Math.max(0, days - next_day);
        return firstthree * first_three_day + nextday * next_day + SETUP_FEE;
    }
    public String label() {
        return "Car";
    }

    
}
