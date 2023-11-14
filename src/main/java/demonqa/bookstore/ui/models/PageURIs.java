package demonqa.bookstore.ui.models;

public enum PageURIs {
    BOOK_STORE_URI("books/"), LOGIN_URI("login/"), PROFILE_URI("profile/");

    private final String uri;

    PageURIs(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
