public class AppointmentBook {

    private boolean[][] schedule;

    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;
        for (int minute = 0; minute < 60; minute++) {
            if (isMinuteFree(period, minute)) {
                block++;
                if (block >= duration) {
                    return minute - duration + 1;
                }
            } else {
                block = 0;
            }
        }
        return -1;
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        for (int i = startMinute; i < startMinute + duration; i++) {
            schedule[period - 1][i] = false;
        }
    }

    public boolean makeAppointment(int duration) {
        for (int period = 1; period <= 8; period++) {
            int start = findFreeBlock(period, duration);
            if (start != -1) {
                reserveBlock(period, start, duration);
                return true;
            }
        }
        return false;
    }

    public void printPeriod(int period) {
        System.out.print("Period " + period + ": ");
        for (int i = 0; i < 60; i++) {
            if (schedule[period - 1][i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
