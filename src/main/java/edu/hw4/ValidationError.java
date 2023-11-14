package edu.hw4;

public record ValidationError(ErrorType type) {

    enum ErrorType {
        WRONG_NAME("имя должно содержать хотя бы один непробельный символ"),
        WRONG_AGE("возраст должен быть больше нуля"),
        WRONG_HEIGHT("рост должен быть больше нуля"),
        WRONG_WEIGHT("вес должен быть больше нуля");

        private final String description;

        ErrorType(String name) {
            description = name;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
