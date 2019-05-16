package pl.marek.html;

class InvalidOptionException extends RuntimeException {
    InvalidOptionException() {
        super("Wrong option");
    }
}