package pl.marek.factoryhtml;

class InvalidOptionException extends RuntimeException {
    InvalidOptionException() {
        super("Wrong option");
    }
}