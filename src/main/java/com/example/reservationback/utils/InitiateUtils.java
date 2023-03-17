package com.example.reservationback.utils;

import com.example.reservationback.model.Person;
import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Restaurant;
import com.example.reservationback.model.Table;
import com.example.reservationback.repository.RestaurantRepository;
import com.example.reservationback.service.ReservationService;
import com.example.reservationback.service.RestaurantService;
import com.example.reservationback.service.TableService;
import com.example.reservationback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class InitiateUtils implements CommandLineRunner {

    @Autowired
    RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;
    private final TableService tableService;
    private final ReservationService reservationService;
    private final UserService userService;

    public InitiateUtils(RestaurantService restaurantService, TableService tableService, ReservationService reservationService, UserService userService) {
        this.restaurantService = restaurantService;
        this.tableService = tableService;
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        Calendar fromR = Calendar.getInstance();
        Calendar untilR = Calendar.getInstance();
        fromR.set(2022, Calendar.SEPTEMBER, 4, 14, 30);
        untilR.set(2022, Calendar.SEPTEMBER, 4, 16, 45);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");

        Person person = new Person("Sergey", "Kurbatov", "s.a.kurbatov@gmail.com", "7742823913474");
        Person person2 = new Person("Igor", "Gorinin", "igorinin@gmail.com", "77432535474");

        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setName("Zerochka");
        restaurant.setAddress("Gde-to tam");
        restaurant.setPhone("880055553535");
        restaurant.setEmail("zeeohka@gmail.com");
        restaurant.setUrl("site.com");
        restaurant.setWorkingHoursFrom(LocalTime.parse("8:00:00", formatter));
        restaurant.setWorkingHoursUntil(LocalTime.parse("23:00:00", formatter));
        restaurant.setDescription("Just a regular rest");
        restaurant.setDefaultReservationTime(LocalTime.parse("3:00:00", formatter));

        Table table1 = new Table();
        table1.setId(2);
        table1.setRestaurant(restaurant);
        table1.setName("first");
        table1.setSeats(5);

        Table table2 = new Table();
        table2.setId(3);
        table2.setRestaurant(restaurant);
        table2.setName("second");
        table2.setSeats(4);

        Reservation reservation = new Reservation();
        reservation.setId(4);
        reservation.setTable(table1);
        reservation.setComment("A couple");
        reservation.setStatus("Reserved");
        reservation.setTimeFrom(fromR);
        reservation.setTimeUntil(untilR);
        reservation.setPerson(person);
        reservation.setSeats(2);

        Reservation reservation2 = new Reservation();
        reservation2.setId(5);
        reservation2.setTable(table2);
        reservation2.setComment("Another couple");
        reservation2.setStatus("Reserved");
        reservation2.setTimeFrom(fromR);
        reservation2.setTimeUntil(untilR);
        reservation2.setPerson(person2);
        reservation2.setSeats(2);

        List<Table> tables = new ArrayList<>();
        tables.add(table1);
        tables.add(table2);
        table1.addReservation(reservation);
        table2.addReservation(reservation2);
        restaurant.setTables(tables);

        restaurantRepository.save(restaurant);
    }
}
