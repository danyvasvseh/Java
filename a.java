enum Day {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);
    
    
    private final boolean weekend;

    Day(boolean weekend) {
        this.weekend = weekend;
    }

}