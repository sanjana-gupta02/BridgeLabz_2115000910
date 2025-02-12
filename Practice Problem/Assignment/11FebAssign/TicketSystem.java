class TicketNode {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head;

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        TicketNode temp = head, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (prev != null) prev.next = temp.next;
                else {
                    TicketNode last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayTickets() {
        if (head == null) return;
        TicketNode temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " + temp.seatNumber + " " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    int countTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Rahul", "Sholay", "A1", "10:00 AM");
        system.addTicket(2, "Priya", "Dilwale Dulhania Le Jayenge", "B2", "2:00 PM");
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
        system.removeTicket(1);
        system.displayTickets();
    }
}
