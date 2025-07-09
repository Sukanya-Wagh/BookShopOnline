package model;

public class Author {
    private int authorId;
    private String name;

    // Constructors
    public Author() {}
    
    public Author(String name) {
        this.name = name;
    }

    public Author(int authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    // Getters & Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                '}';
    }
}
