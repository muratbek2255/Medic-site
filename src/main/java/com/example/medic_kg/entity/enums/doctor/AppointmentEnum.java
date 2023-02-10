package com.example.medic_kg.entity.enums.doctor;

public enum AppointmentEnum {
    NONE(0),			// если статус не найден, вернуть как статус по умолчанию
    BOOKED(1),			// статус ЗАРЕЗЕРВИРОВАН создается после записи пациента на прием
    RECEIVED(2),		// администратор меняет статус с ЗАБРОНИРОВАТЬ на ПОЛУЧЕНО после прибытия пациента в офис
    COMPLETED(3),		// врач меняет статус с ПОЛУЧЕНО на ЗАВЕРШЕНО после того, как заполнит подробную форму назначения.
    NOT_ARRIVED(4),		// администратор меняет статус с BOOKED на NOT_ARRIVED в конце дня
    CANCELED(5);		// администратор меняет статус с ЗАПИСАН на ОТМЕНА, если пациент звонит в офис, чтобы отменить прием

    private int value;

    private AppointmentEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AppointmentEnum getEnum(int num){
        for (AppointmentEnum item : AppointmentEnum.values()) {
            if(item.getValue() == num)
                return item;
        }
        return AppointmentEnum.NONE;
    }
}
