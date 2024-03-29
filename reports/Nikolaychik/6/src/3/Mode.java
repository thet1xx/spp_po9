public enum Mode {

    WAIT ("Ожидание"),
    IN_PROCESS ("выполнение операции"),
    AUTH ("аутентификация"),
    BLOCKED ("блокировка");

    private String title;

    Mode(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
