package com.example.creational.builder;

public class Main {

    public static void main(String[] args) {

        User user1 = new User.Builder().setId(1L).build();
        User user2 = new User.Builder().setId(1L).setFirstName("Alan").build();
        User user3 = new User.Builder().setId(1L).setFirstName("Alan").setLastName("Sastre").build();
        User user4 = new User.Builder()
                .setId(1L)
                .setFirstName("Alan")
                .setLastName("Sastre")
                .setEmail("asasa@asas.com")
                .build();

        User user5 = new User.Builder()
                .setId(1L).setFirstName("Alan").setLastName("Sastre")
                .setEmail("asasa@asas.com").setMarried(false)
                .build();

        User user6 = new User.Builder()
                .setMarried(true).setFirstName("Alan").setLastName("Sastre")
                .setEmail("asasa@asas.com").setId(6L)
                .build();
    }
}

class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean married;

    public User(Long id, String firstName, String lastName, String email, Boolean married) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.married = married;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public static class Builder {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean married;

        User build() {
            // En caso de necesitar obligar a rellenar ciertas propiedades
//			if(this.id == null || this.email == null)
//				throws FieldsMandatory();
            return new User(this.id, this.firstName, this.lastName, this.email, this.married);
        }

        // Métodos GETTER
        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public Boolean getMarried() {
            return married;
        }

        // Métodos SETTER estilo Fluent, devolviendo this

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMarried(Boolean married) {
            this.married = married;
            return this;
        }

    }

}