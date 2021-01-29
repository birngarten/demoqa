package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "userId",
            "username",
            "books"
    })
    public class DemoqaGetPojo {

        @JsonProperty("userId")
        private String userId;
        @JsonProperty("username")
        private String username;
        @JsonProperty("books")
        private List<Book> books = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public DemoqaGetPojo() {
        }

        /**
         *
         * @param books
         * @param userId
         * @param username
         */
        public DemoqaGetPojo(String userId, String username, List<Book> books) {
            super();
            this.userId = userId;
            this.username = username;
            this.books = books;
        }

        @JsonProperty("userId")
        public String getUserId() {
            return userId;
        }

        @JsonProperty("userId")
        public void setUserId(String userId) {
            this.userId = userId;
        }

        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

        @JsonProperty("books")
        public List<Book> getBooks() {
            return books;
        }

        @JsonProperty("books")
        public void setBooks(List<Book> books) {
            this.books = books;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("userId", userId).append("username", username).append("books", books).toString();
        }

    }
