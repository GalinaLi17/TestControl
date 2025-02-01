package Elevator;
import java.util.Random;
public class ElevatorSystem {
    public static void main(String[] args) {

        EvenFloorElevator[] evenElevators = new EvenFloorElevator[3];
        OddFloorElevator[] oddElevators = new OddFloorElevator[3];
        EmployeeElevator employeeElevator = new EmployeeElevator();

        for (int i = 0; i < 3; i++) {
            evenElevators[i] = new EvenFloorElevator();
            oddElevators[i] = new OddFloorElevator();
        }


        for (int i = 0; i < 10000; i++) {
            if (i % 20 == 0) {
                Random rand = new Random();
                int elevatorType = rand.nextInt(3);  // (0 - четный, 1 - нечетный, 2 - сотрудник)
                int floor = rand.nextInt(10) + 1;

                try {

                    if (elevatorType == 0) {
                        EvenFloorElevator elevator = evenElevators[rand.nextInt(3)];
                        callElevator(elevator, floor);
                    } else if (elevatorType == 1) {
                        OddFloorElevator elevator = oddElevators[rand.nextInt(3)];
                        callElevator(elevator, floor);
                    } else {
                        callElevator(employeeElevator, floor);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }


            moveElevators(evenElevators);
            moveElevators(oddElevators);
            moveElevators(new EmployeeElevator[]{employeeElevator});
        }
    }


    private static void callElevator(AbstractElevator elevator, int floor) throws Exception {
        if (elevator.getState() == ElevatorState.STANDING) {
            elevator.callElevator(1);
            System.out.println("Лифт вызван на этаж: " + floor);
        } else {
            throw new Exception("Лифт занят или неисправен.");
        }
    }

    private static void moveElevators(AbstractElevator[] elevators) {
        for (AbstractElevator elevator : elevators) {
            elevator.move();
        }
    }
}
