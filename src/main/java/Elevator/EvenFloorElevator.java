package Elevator;

public class EvenFloorElevator extends AbstractElevator {
    public EvenFloorElevator() {
        super(ElevatorState.STANDING, 1, null);
    }

    @Override
    public void callElevator(int floor) throws Exception {
        if (floor % 2 != 0) {
            throw new Exception("Этот лифт обслуживает только четные этажи");
        }
        super.callElevator(floor);
    }
}

