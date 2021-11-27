package com.leadsquared.ecommerceapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Book extends Product {

    private String author;
    private int publicationYear;
    private boolean imported;

    public enum CategoryEnum{
        MANAGEMENT("management"),
        SELFHELP("SELF-HELP"),
        INVALID_CATEGORY("Invalid");


        private String value;

        CategoryEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CategoryEnum{" +
                    "value='" + value + '\'' +
                    '}';
        }

        @JsonCreator
        public static CategoryEnum fromValue(String text) {
            for (CategoryEnum b : CategoryEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                        return b;
                }
            }
            return CategoryEnum.INVALID_CATEGORY;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
}
