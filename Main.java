public class Main {
    public static void main(String[] args) {
        boolean[][] schedule = new boolean[8][60];

        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[0].length; j++) {
                schedule[i][j] = false;
            }
        }

        for (int i = 10; i <= 14; i++) {
            schedule[1][i] = true;
        }

        for (int i = 30; i <= 44; i++) {
            schedule[1][i] = true;
        }

        for (int i = 50; i <= 59; i++) {
            schedule[1][i] = true;
        }

        AppointmentBook book = new AppointmentBook(schedule);

        book.printPeriod(2);

        boolean result = book.makeAppointment(15);
        System.out.println("Appointment success: " + result);

        book.printPeriod(2);
    }
}
