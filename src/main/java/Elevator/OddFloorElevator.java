package Elevator;

public class OddFloorElevator extends AbstractElevator {
    public OddFloorElevator() {
        super(ElevatorState.STANDING, 1, null);
    }

    @Override
    public void callElevator(int floor) throws Exception {
        if (floor % 2 == 0) {
            throw new Exception("Этот лифт обслуживает только нечетные этажи");
        }
        super.callElevator(floor);
    }
}