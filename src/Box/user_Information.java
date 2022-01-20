package Box;

public class user_Information {
    private String list;
    private String page;
    user_Information[] _GET = new user_Information[]{new user_Information("customers", "2"), new user_Information("customers", "2"), new user_Information("customers", "2"), new user_Information("foo", "bar"), new user_Information("foo", "bar"), new user_Information("foo", "bar")};

    public user_Information(String list, String page) {
        this.list = list;
        this.page = page;
    }

    public String getList() {
        return this.list;
    }

    public String getPage() {
        return this.page;
    }
}
