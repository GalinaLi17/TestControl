package Elevator;

public class ElevatorCall implements CallElevator {
    protected CallType callType;
    protected int destinationFloor;

    public ElevatorCall(CallType callType, int destinationFloor) {
        this.callType = callType;
        this.destinationFloor = destinationFloor;
    }

    @Override
    public CallType getCallType() {
        return callType;
    }

    @Override
    public int getDestinationFloor() {
        return destinationFloor;
    }
}

