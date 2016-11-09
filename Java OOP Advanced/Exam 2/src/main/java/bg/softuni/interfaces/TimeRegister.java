package bg.softuni.interfaces;

public interface TimeRegister {

    Integer getHour();

    Integer getMinutes();

    Integer getDay();

    Integer getMonth();

    Integer getYear();

    @Override
    String toString();
}
