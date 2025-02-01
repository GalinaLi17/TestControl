package Elevator;

abstract public class AbstractElevator implements Elevator {
    protected ElevatorState state; // Текущее состояние
    protected int currentFloor;    // Текущий этаж
    protected Integer destinationFloor; // Этаж назначения (может быть null)

    public AbstractElevator(ElevatorState state, int currentFloor, Integer destinationFloor) {
        this.state = state;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }
    @Override
    public ElevatorState getState() {
        return state;
    }
    public void callElevator(int floor) throws Exception {
        if (state == ElevatorState.MOVING_UP || state == ElevatorState.MOVING_DOWN || state == ElevatorState.NOT_WORKING) {
            throw new Exception("Лифт занят или неисправен");
        }
        this.destinationFloor = floor;
        if (floor > currentFloor) {
            state = ElevatorState.MOVING_UP;
        } else if (floor < currentFloor) {
            state = ElevatorState.MOVING_DOWN;
        } else {
            state = ElevatorState.STANDING;
        }
    }
    public void move() {
        if (state == ElevatorState.MOVING_UP) {
            currentFloor++;
            if (currentFloor == destinationFloor) {
                state = ElevatorState.STANDING;
                destinationFloor = null;
            }
        } else if (state == ElevatorState.MOVING_DOWN) {
            currentFloor--;
            if (currentFloor == destinationFloor) {
                state = ElevatorState.STANDING;
                destinationFloor = null;
            }
        }
    }
}
